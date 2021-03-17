package com.rajeshkawali.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajeshkawali.entity.Employee;

@Repository
public interface EmployeeDoa extends JpaRepository<Employee, Long>{

	
}
