package com.serhiiboiko.spring_boot_app.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@ManyToMany(mappedBy="employees")
	@JsonManagedReference
	private List<Department> departments;
	public Employee() {};

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Department> getDepartments() {
		return departments;
	}
	
	
	
	
	
}
