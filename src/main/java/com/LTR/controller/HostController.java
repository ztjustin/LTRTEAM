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
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import javax.servlet.http.HttpServletRequest;

import com.LTR.entity.Host;
import com.LTR.service.HostService;
import com.LTR.service.PlatformService;

@Controller
public class HostController {

	@Autowired
	@Qualifier("hostServiceImpl")
	private HostService hostServiceImpl;

	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;

	private static final Log LOG = LogFactory.getLog(HostController.class);

	@GetMapping("/admin/hosts")
	private ModelAndView listHosts() {

		ModelAndView view = new ModelAndView("hostList");
		view.addObject("hosts", hostServiceImpl.getAll());

		return view;
	}

	@PostMapping({ "/admin/editHost" })
	public String addOrEditHost(@ModelAttribute(name = "host") Host host,final RedirectAttributes redirectAttributes,
	HttpServletRequest request, Model model) {

		host.setPlatform(platformServiceImpl.getOne(host.getPlatform().getPlatformId()));

		String messageString  = null;
		
		try {
						
			if(host.getHostId() == null) {
				messageString = "insertedHost";
			}else {				
				messageString = "updatedHost";
			}
	
			hostServiceImpl.addOne(host);
			
			redirectAttributes.addFlashAttribute("success",messageString);
			return "redirect:/admin/step5/" + host.getPlatform().getPlatformId();
			
		}catch(Exception ex) {
			redirectAttributes.addFlashAttribute("error",messageString);
			return "redirect:/admin/error";
		}

	}
	
	@PostMapping({ "/admin/returnHost" })
	public String addOrEditHost(@RequestParam(name = "hostId") Long hostId,@RequestParam(name = "platformId") Long platformId,
	final RedirectAttributes redirectAttributes,HttpServletRequest request, Model model) {

		String messageString  = null;
		
		try {

						
			hostServiceImpl.delete(hostId);
			
			messageString = "hostDeleted";
			redirectAttributes.addFlashAttribute("success",messageString);
			
			return "redirect:/admin/step5/" + platformId;
			
		}catch(Exception ex) {
			LOG.info(ex.toString());
			redirectAttributes.addFlashAttribute("error",messageString);
			return "redirect:/admin/error";
		}

	}

	@PostMapping({ "/admin/addHostToPlatform" })
	public String assignHost(@ModelAttribute(name = "host") Host host,
	final RedirectAttributes redirectAttributes,HttpServletRequest request, Model model) {

		host.setPlatform(platformServiceImpl.getOne(host.getPlatform().getPlatformId()));

		String messageString  = null;
		
		try {
						
			hostServiceImpl.addOne(host);
			
			messageString = "hostAdded";
			redirectAttributes.addFlashAttribute("success",messageString);
			
			return "redirect:/admin/step5/" + host.getPlatform().getPlatformId();
			
		}catch(Exception ex) {
			redirectAttributes.addFlashAttribute("error",messageString);
			return "redirect:/admin/error";
		}

    }

}
