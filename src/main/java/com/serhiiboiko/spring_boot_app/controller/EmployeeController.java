package com.serhiiboiko.spring_boot_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serhiiboiko.spring_boot_app.entity.Employee;
import com.serhiiboiko.spring_boot_app.exception.ResourceNotFoundException;
import com.serhiiboiko.spring_boot_app.repository.DepartmentRepository;
import com.serhiiboiko.spring_boot_app.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	
	@GetMapping("")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "id", Integer.toString(id)));
	}
	
	@PostMapping("")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		return employeeRepository.save(newEmployee);
	}
	
	@PutMapping("/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable int id) {

		return employeeRepository.findById(id)
			.map(employee -> {
				employee.setName(newEmployee.getName());
				return employeeRepository.save(employee);
			})
			.orElseGet(() -> {
				newEmployee.setId(id);
				return employeeRepository.save(newEmployee);
			});
	}
	
	@DeleteMapping("/{id}")
	void deleteEmployee(@PathVariable int  id) {
		employeeRepository.deleteById(id);
	}
	
}
