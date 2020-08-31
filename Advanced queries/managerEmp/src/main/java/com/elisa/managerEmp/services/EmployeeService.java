package com.elisa.managerEmp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.elisa.managerEmp.models.Employee;
import com.elisa.managerEmp.repositories.EmployeeRepo;


@Service
public class EmployeeService {
	private final EmployeeRepo empRepo;

	public EmployeeService(EmployeeRepo empRepo) {
		this.empRepo = empRepo;
	}
	//Devuelve todo los empleados
	public List<Employee> allEmployees() {
		return empRepo.findAll();
	}
	
	//Crea un empleado
	public Employee newEmployee(Employee e) {
		return empRepo.save(e);
	}
	//Busca un empleado
	  public Employee findEmployee(Long id) {
	        Optional<Employee> temp = empRepo.findById(id);
	        if(temp.isPresent()) {
	            return temp.get();
	        } else {
	            return null;
	        }
	    }
	  public Employee setManager(Long id, Employee employee) {
			Optional<Employee> temp = empRepo.findById(id);
			 if(temp.isPresent()) {
				 Employee e = temp.get();
				e.setManager(employee);
				 return empRepo.save(e);
		        } else {
		        	return null;
		        }
		}

}
