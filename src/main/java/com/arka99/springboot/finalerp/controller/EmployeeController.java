package com.arka99.springboot.finalerp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arka99.springboot.finalerp.entity.Employee;
import com.arka99.springboot.finalerp.service.EmployeeService;

import javax.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get employees from db
		List<Employee> theEmployees = employeeService.findAll();
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "/employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "/employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);
		employeeService.deleteById(theId);
		
		// send over to our form
		return "/employees/employee-form";			
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@Valid Employee employee, BindingResult bindingResult, Model model){
			if(bindingResult.hasErrors()) {
				return "/employees/employee-form";
			}
			employeeService.save(employee);
			return "redirect:/employees/list";

		}

	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		// delete the employee
		employeeService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam("employeeName") String theName,
						 Model theModel) {
		
		// delete the employee
		List<Employee> theEmployees = employeeService.searchBy(theName);
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		// send to /employees/list
		return "/employees/list-employees";
		
	}
	
}


















