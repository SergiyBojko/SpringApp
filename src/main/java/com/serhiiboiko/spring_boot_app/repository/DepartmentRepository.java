package com.serhiiboiko.spring_boot_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serhiiboiko.spring_boot_app.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
