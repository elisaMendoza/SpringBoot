package com.elisa.dojosninjas.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.elisa.dojosninjas.models.Dojo;
import com.elisa.dojosninjas.models.Ninja;
import com.elisa.dojosninjas.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;

	public NinjaController(NinjaService ninjaService) {
		this.ninjaService = ninjaService;
	}
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
    public String create(@RequestParam(name="dojos") Dojo dojo, @RequestParam(name="firstName") String firstName, @RequestParam(name="lastName") String lastName, @RequestParam(name="age") int age) { 
        Ninja ninja = new Ninja(firstName, lastName, age, dojo);	
		ninjaService.createNinja(ninja);
            return "redirect:/";
        }

	@RequestMapping("/ninjas")
    public ResponseEntity<List<Ninja>> getAllNinjas(
                        @RequestParam(defaultValue = "0") Integer pageNo, 
                        @RequestParam(defaultValue = "5") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy) 
    {
        List<Ninja> list = ninjaService.getAllNinjas(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<Ninja>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
}
