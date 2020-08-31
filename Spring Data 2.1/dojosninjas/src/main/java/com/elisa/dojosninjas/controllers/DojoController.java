package com.elisa.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.elisa.dojosninjas.models.Dojo;
import com.elisa.dojosninjas.services.DojoService;

@Controller
public class DojoController {
	private final DojoService dojoService;

	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	@RequestMapping("/")
    public String index(Model model) {
	  List<Dojo> dojos = dojoService.allDojos();
	  model.addAttribute("dojos", dojos);
        return "/index.jsp";
    }
	@RequestMapping("/dojos/{id}")
    public String dojoList(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
        return "/dojo.jsp";
    }
  @RequestMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "/newDojo.jsp";
    }
  @RequestMapping(value="/dojos/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) { 
		if (result.hasErrors()) {
    		 return "/newDojo.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/";
        }
	}

 @RequestMapping("/ninjas/new")
    public String ninjasDojo(/*@ModelAttribute("ninja") Ninja ninja,*/ Model model) {
	  List<Dojo> dojos = dojoService.allDojos();
       model.addAttribute("dojos", dojos);
        return "/newNinja.jsp";
    }
	

}
