package com.arka99.springboot.finalerp.service;

import java.util.List;
import java.util.Optional;

import com.arka99.springboot.finalerp.controller.ValidationExceptionHandler;
import com.arka99.springboot.finalerp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arka99.springboot.finalerp.dao.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new ValidationExceptionHandler();
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

	@Override
	public List<Employee> searchBy(String theName) {
		
		List<Employee> employees = employeeRepository.findAllByNameIgnoreCase(theName);
		if(employees.isEmpty())
			throw new  ValidationExceptionHandler();
		else
			return employees;
	}

}






