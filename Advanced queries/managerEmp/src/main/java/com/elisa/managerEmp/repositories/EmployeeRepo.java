package com.elisa.managerEmp.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.elisa.managerEmp.models.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
	List<Employee> findAll();

}
