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

import com.LTR.entity.Pdu;
import com.LTR.service.PduService;
import com.LTR.service.PlatformService;

@Controller
public class PduController {
	
	@Autowired
	@Qualifier("pduServiceImpl")
	private PduService pduServiceImpl;

	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;
	
	@GetMapping("/admin/pdus")
	private ModelAndView listPdus() {
		
		ModelAndView view = new ModelAndView("pdusList");
		view.addObject("pdus", pduServiceImpl.getAll());
		
		return view;
		
		
	}


	@PostMapping({"/admin/editPdu"})
    public String addOrEditKvm(@ModelAttribute(name="pdu") Pdu pdu,
    		final RedirectAttributes redirectAttributes,HttpServletRequest request,Model model) {
		
		pdu.setPlatform(platformServiceImpl.getOne(pdu.getPlatform().getPlatformId()));

		String messageString  = null;
		
		try {
			
			
			if(pdu.getPduId() == null) {
				messageString = "insertedPdu";
			}else {				
				messageString = "updatedPdu";
			}
			
			pduServiceImpl.addOne(pdu);
			
			redirectAttributes.addFlashAttribute("success",messageString);
			return "redirect:/admin/step5/" + pdu.getPlatform().getPlatformId();
			
		}catch(Exception ex) {
			redirectAttributes.addFlashAttribute("error",messageString);
			return "redirect:/admin/platform";
		}

	}
	
	@PostMapping({ "/admin/returnPdu" })
	public String addOrEditHost(@RequestParam(name = "pduId") Long pduId,final RedirectAttributes redirectAttributes,
	HttpServletRequest request, Model model) {


		String messageString  = null;
		
		try {

			Pdu pduToNull = pduServiceImpl.getOne(pduId);
			pduToNull.setPlatform(null);
						
			pduServiceImpl.addOne(pduToNull);
			
			messageString = "pduReturned";
			redirectAttributes.addFlashAttribute("success",messageString);
			
			return "redirect:/admin/hosts";
			
		}catch(Exception ex) {
			redirectAttributes.addFlashAttribute("error",messageString);
			return "redirect:/admin/error";
		}

	}
	
	@PostMapping({ "/admin/addPduToPlatform" })
	public String assignPdu(@RequestParam(name = "pduId",required = true) Long pduId,@RequestParam(name = "platformId") Long platformId,
	final RedirectAttributes redirectAttributes,HttpServletRequest request, Model model) {


		String messageString  = null;
		
		try {

			Pdu pduToNull = pduServiceImpl.getOne(pduId);
			pduToNull.setPlatform(platformServiceImpl.getOne(platformId));
						
			pduServiceImpl.addOne(pduToNull);
			
			messageString = "pduAdded";
			redirectAttributes.addFlashAttribute("success",messageString);
			
			return "redirect:/admin/step5/" + platformId;
			
		}catch(Exception ex) {
			redirectAttributes.addFlashAttribute("error",messageString);
			return "redirect:/admin/error";
		}

    }

}
