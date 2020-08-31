package com.elisa.language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elisa.language.services.LanguageService;
import com.elisa.language.models.Language;

@Controller
public class LanguageController {
	private final LanguageService langService;
	
	public LanguageController(LanguageService langService) {
		this.langService = langService;
	}
	 @RequestMapping("/languages")
	    public String index(Model model) {
	        List<Language> language = langService.allLanguages();
	        model.addAttribute("language", language);
	        return "/index.jsp";
	    }
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) { 
			if (result.hasErrors()) {
	    		 return "/index.jsp";
	        } else {
	            langService.createLanguage(language);
	            return "redirect:/languages";
	        }
		}
	 
	 @RequestMapping("/languages/{id}")
	    public String showLanguage(@PathVariable("id") Long id, Model model) {
	    	Language language = langService.findLanguage(id);
	        model.addAttribute("language", language);
	        return "/show.jsp";
	    }
		 
	  @RequestMapping("/languages/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Language language = langService.findLanguage(id);
	        model.addAttribute("language", language);
	        return "/edit.jsp";
	    }
	  @RequestMapping(value="/languages/{id}", method=RequestMethod.POST)
	    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/edit.jsp";
	        } else {
	            langService.updateLanguage(language);
	            return "redirect:/languages";
	        }
	    }
	  @RequestMapping("/languages/delete/{id}")
	    public String destroy(@PathVariable("id") Long id) {
	        langService.deleteLanguage(id);
	        return "redirect:/languages";
	    }

}
