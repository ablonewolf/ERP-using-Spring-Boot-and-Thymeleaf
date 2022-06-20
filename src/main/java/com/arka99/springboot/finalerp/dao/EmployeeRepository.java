package com.arka99.springboot.finalerp.dao;

import java.util.List;

import com.arka99.springboot.finalerp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
	// add a method to sort by last name
	public List<Employee> findAllByNameIgnoreCase(String name);

}
