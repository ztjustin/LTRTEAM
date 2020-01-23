package com.LTR.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import com.LTR.entity.Kvm;
import com.LTR.service.KvmService;
import com.LTR.service.PlatformService;

@Controller
public class KvmController {

	
	@Autowired
	@Qualifier("kvmServiceImpl")
	private KvmService kvmServiceImpl;
	
	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;

	
	@GetMapping("/admin/kvms")
	private ModelAndView listKvm() {
		
		ModelAndView view = new ModelAndView("kvmList");
		view.addObject("kvms", kvmServiceImpl.getAll());
		
		return view;
		
	}


	@PostMapping({"/admin/editKvm"})
    public String addOrEditKvm(@ModelAttribute(name="kvm") Kvm kvm,
    		final RedirectAttributes redirectAttributes,HttpServletRequest request,Model model) {
		
		kvm.setPlatform(platformServiceImpl.getOne(kvm.getPlatform().getPlatformId()));

		String messageString  = null;
		
		try {
			
			
			if(kvm.getKvmId() == null) {
				messageString = "insertedKvm";
			}else {				
				messageString = "updatedKvm";
			}
			
			kvmServiceImpl.addOne(kvm);
			
			redirectAttributes.addFlashAttribute("success",messageString);
			return "redirect:/admin/step5/" + kvm.getPlatform().getPlatformId();
			
		}catch(Exception ex) {
			redirectAttributes.addFlashAttribute("error",messageString);
			return "redirect:/admin/platform";
		}

	}
	
	@PostMapping({ "/admin/returnKvm" })
	public String addOrEditKvm(@RequestParam(name = "kvmId") Long kvmId,final RedirectAttributes redirectAttributes,
	HttpServletRequest request, Model model) {


		String messageString  = null;
		
		try {

			Kvm kvmToNull = kvmServiceImpl.getOne(kvmId);
			kvmToNull.setPlatform(null);
						
			kvmServiceImpl.addOne(kvmToNull);
			
			messageString = "kvmReturned";
			redirectAttributes.addFlashAttribute("success",messageString);
			
			return "redirect:/admin/hosts";
			
		}catch(Exception ex) {
			redirectAttributes.addFlashAttribute("error",messageString);
			return "redirect:/admin/error";
		}

	}

	@PostMapping({ "/admin/addKvmToPlatform" })
	public String assignPdu(@RequestParam(name = "kvmId",required = true) Long pduId,@RequestParam(name = "platformId") Long platformId,
	final RedirectAttributes redirectAttributes,HttpServletRequest request, Model model) {


		String messageString  = null;
		
		try {

			Kvm pduToNull = kvmServiceImpl.getOne(pduId);
			pduToNull.setPlatform(platformServiceImpl.getOne(platformId));
						
			kvmServiceImpl.addOne(pduToNull);
			
			messageString = "kvmAdded";
			redirectAttributes.addFlashAttribute("success",messageString);
			
			return "redirect:/admin/step5/" + platformId;
			
		}catch(Exception ex) {
			redirectAttributes.addFlashAttribute("error",messageString);
			return "redirect:/admin/error";
		}

    }	
		
}
