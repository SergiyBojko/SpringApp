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

import com.serhiiboiko.spring_boot_app.entity.Department;
import com.serhiiboiko.spring_boot_app.exception.ResourceNotFoundException;
import com.serhiiboiko.spring_boot_app.repository.DepartmentRepository;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	DepartmentRepository departmentRepository;
	
	@GetMapping("")
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable int id) {
		return departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("department", "id", Integer.toString(id)));
	}
	
	@PostMapping("")
	public Department createDepartment (@RequestBody Department newDepartment) {
		return departmentRepository.save(newDepartment);
	}
	
	@PutMapping("/{id}")
	public Department updateDepartment (@RequestBody Department newDepartment, @PathVariable int id) {
		return departmentRepository.findById(id)
				.map(department -> {
					department.setName(newDepartment.getName());
					department.setDescription(newDepartment.getDescription());
					return departmentRepository.save(department);
				})
				.orElseGet(()->{
					newDepartment.setId(id);
					return departmentRepository.save(newDepartment);
				});
	}
	
	@DeleteMapping("/{id}")
	void deleteDepartment (@PathVariable int id) {
		departmentRepository.deleteById(id);
	}
}
