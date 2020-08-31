package com.elisa.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.elisa.relationships.models.License;
import com.elisa.relationships.services.LicenseService;


@Controller
public class LicenseController {
private final LicenseService lService;
	
	public LicenseController(LicenseService lService ) {
		this.lService = lService;
	}
	  @RequestMapping(value="/licenses/create", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("license") License license, BindingResult result) { 
			if (result.hasErrors()) {
	    		 return "/newLicense.jsp";
	        } else {
	        	String number = lService.generateLicenseNumber();
				license.setNumber(number);
	            lService.createLicense(license);
	            return "redirect:/";
	        }
		}
}
