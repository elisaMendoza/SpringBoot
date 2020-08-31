package com.elisa.countries.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elisa.countries.services.ApiService;

@Controller
@RequestMapping("/")
public class QueryController {
	private final ApiService apiService;
	
	public QueryController(ApiService apiService) {
		this.apiService = apiService;
	}
	@RequestMapping("/question1")
	public String exercise1(Model model) {
		ArrayList<String> columns = new ArrayList<String>(); //Crea un nuevo array para las columnas.
		columns.add("País"); //Titulo de la columa 1 de la tabla
		columns.add("Lenguaje");
		columns.add("Porcentaje del lenguaje (%)");
        model.addAttribute("columns", columns); //Toma los datos anteriories para generar columas necesarias
    	model.addAttribute("numEjercicio", "Ejercicio 1"); // Titulo de mi card(Mi tabla esta dentro de un card NO ES NECESARIO)
        model.addAttribute("tabla", apiService.question1()); //Toma los datos de servicio para llenar los datos rescatados del query
		return "/query.jsp";
	}
	@RequestMapping("/question2")
	public String exercise2(Model model) {
		ArrayList<String> columns = new ArrayList<String>();
		columns.add("Pais"); 
		columns.add("Cantidad de Ciudades"); 
        model.addAttribute("columns", columns); 
    	model.addAttribute("numEjercicio", "Ejercicio 2"); 
        model.addAttribute("tabla", apiService.question2()); 
		return "/query.jsp";
	}
	@RequestMapping("/question3")
	public String exercise3(Model model) {
		ArrayList<String> columns = new ArrayList<String>(); 
		columns.add("Ciudad"); 
		columns.add("Población Total"); 
        model.addAttribute("columns", columns); 
    	model.addAttribute("numEjercicio", "Ejercicio 3"); 
        model.addAttribute("tabla", apiService.question3()); 
		return "/query.jsp";
	}
	@RequestMapping("/question4")
	public String exercise4(Model model) {
		ArrayList<String> columns = new ArrayList<String>(); 
		columns.add("País"); 
		columns.add("Lenguaje");
		columns.add("Porcentaje (%)");
        model.addAttribute("columns", columns); 
    	model.addAttribute("numEjercicio", "Ejercicio 4"); 
        model.addAttribute("tabla", apiService.question4()); 
		return "/query.jsp";
	}
	@RequestMapping("/question5")
	public String exercise5(Model model) {
		ArrayList<String> columns = new ArrayList<String>(); 
		columns.add("País"); 
		columns.add("Superficie total");
		columns.add("Población total");
        model.addAttribute("columns", columns); 
    	model.addAttribute("numEjercicio", "Ejercicio 5"); 
        model.addAttribute("tabla", apiService.question5()); 
		return "/query.jsp";
	}
	@RequestMapping("/question6")
	public String exercise6(Model model) {
		ArrayList<String> columns = new ArrayList<String>(); 
		columns.add("País"); 
		columns.add("Sistema de gobierno");
		columns.add("Superficie total");
		columns.add("Expectativa de vida");
        model.addAttribute("columns", columns); 
    	model.addAttribute("numEjercicio", "Ejercicio 6"); 
        model.addAttribute("tabla", apiService.question6()); 
		return "/query.jsp";
	}
	@RequestMapping("/question7")
	public String exercise7(Model model) {
		ArrayList<String> columns = new ArrayList<String>(); 
		columns.add("País"); 
		columns.add("Ciudad");
		columns.add("Distrito");
		columns.add("Población total");
        model.addAttribute("columns", columns); 
    	model.addAttribute("numEjercicio", "Ejercicio 7"); 
        model.addAttribute("tabla", apiService.question7()); 
		return "/query.jsp";
	}
	@RequestMapping("/question8")
	public String exercise8(Model model) {
		ArrayList<String> columns = new ArrayList<String>(); 
		columns.add("Región"); 
		columns.add("Número de países");
        model.addAttribute("columns", columns); 
    	model.addAttribute("numEjercicio", "Ejercicio 8"); 
        model.addAttribute("tabla", apiService.question8()); 
		return "/query.jsp";
	}

}
