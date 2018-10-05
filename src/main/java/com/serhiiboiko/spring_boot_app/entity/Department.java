package com.serhiiboiko.spring_boot_app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
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
	@Setter(value=AccessLevel.PRIVATE) 
	private List<Employee> employees;
	
	public Department () {
		employees = new ArrayList<>();
	}

	public Department (String name, String description) {
		this();
		this.name = name;
		this.description = description;
	}
}
