package com.elisa.relationships.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.elisa.relationships.models.Person;
import com.elisa.relationships.services.PersonService;

@Controller
public class PersonController {
	private final PersonService pService;
	
	public PersonController(PersonService pService ) {
		this.pService = pService;
	}
	  @RequestMapping("/")
	    public String index(Model model) {
		  List<Person> persons = pService.allPersons();
	       model.addAttribute("persons", persons);
	        return "/index.jsp";
	    }
	  @RequestMapping("/persons/new")
	    public String newPerson(@ModelAttribute("person") Person person) {
	        return "/newPerson.jsp";
	    }
	  @RequestMapping(value="/persons/new", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) { 
			if (result.hasErrors()) {
	    		 return "/newPerson.jsp";
	        } else {
	            pService.createPerson(person);
	            return "redirect:/";
	        }
		}
	  @RequestMapping("/persons/{id}")
	    public String showPerson(@PathVariable("id") Long id, Model model) {
	    	Person person = pService.findPerson(id);
	        model.addAttribute("person", person);
	        return "/person.jsp";
	    }
	 @RequestMapping("/licenses/new")
	    public String personsLicense(/*@ModelAttribute("license") License license,*/ Model model) {
		  List<Person> persons = pService.allPersons();
	       model.addAttribute("persons", persons);
	        return "/newLicense.jsp";
	    }

}
