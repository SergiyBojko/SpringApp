package com.serhiiboiko.spring_boot_app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@ManyToMany(mappedBy="employees")
	@JsonManagedReference
	@Setter(value=AccessLevel.PRIVATE) 
	private List<Department> departments;
	
	public Employee () {
		departments = new ArrayList<>();
	}
	
	public Employee (String name) {
		this();
		this.name = name;
	}
}
