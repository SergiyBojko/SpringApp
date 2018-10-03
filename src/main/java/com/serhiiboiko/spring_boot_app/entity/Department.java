package com.serhiiboiko.spring_boot_app.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Department {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	@ManyToMany
	@JoinTable (
			name="employee_department",
			joinColumns = { @JoinColumn(name = "id_department") }, 
	        inverseJoinColumns = { @JoinColumn(name = "id_employee") }
	)
	@JsonBackReference
	private List<Employee> employees;
	
	public Department () {}
	
	public Department(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

}
