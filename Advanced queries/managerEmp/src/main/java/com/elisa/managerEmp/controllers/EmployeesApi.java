package com.elisa.managerEmp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.elisa.managerEmp.models.Employee;
import com.elisa.managerEmp.services.EmployeeService;

@RestController
public class EmployeesApi {
	private final EmployeeService empService;

	public EmployeesApi(EmployeeService empService) {
		this.empService = empService;
	}
	@RequestMapping("/api/employees")
    public List<Employee> index() {
        return empService.allEmployees();
    }
	@RequestMapping(value="/api/employees", method=RequestMethod.POST)
    public Employee create(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return empService.newEmployee(employee);
    }
	@RequestMapping(value="/api/manager", method=RequestMethod.POST)
	public Employee setManager(@RequestParam("id") Long id, @RequestParam("man_id") Long man_id ) {
		Employee employee = empService.findEmployee(id);
		Employee manager = empService.findEmployee(man_id);
		employee.setManager(manager);
		return empService.newEmployee(employee);
	}
	@RequestMapping(value="/api/manager/{id}")
	public List<Employee> getSubordinate(@PathVariable("id") Long id) {
		Employee manager = empService.findEmployee(id);
		return manager.getSubordinates();
	}
	
	

}
