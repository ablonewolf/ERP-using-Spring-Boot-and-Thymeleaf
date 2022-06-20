package com.arka99.springboot.finalerp.service;

import java.util.List;

import com.arka99.springboot.finalerp.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);

	public List<Employee> searchBy(String theName);
	
}
