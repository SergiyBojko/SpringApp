package com.serhiiboiko.spring_boot_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serhiiboiko.spring_boot_app.entity.Employee;
import com.serhiiboiko.spring_boot_app.exception.ResourceNotFoundException;
import com.serhiiboiko.spring_boot_app.repository.DepartmentRepository;
import com.serhiiboiko.spring_boot_app.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	
	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "id", Integer.toString(id)));
	}

	
	
}
