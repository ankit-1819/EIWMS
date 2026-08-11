package com.eiwms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiwms.entity.Employee;
import com.eiwms.service.EmployeeService;

@RestController
@RequestMapping("/eiwms")
public class EiwmsController {

	private final EmployeeService employeeService;
	
	
	
	public EiwmsController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}


	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		
		return employeeService.updateEmployee(employee, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		
		employeeService.deleteEmployee(id);
		
		return "Successfully Employee Deleted from Database";
	}
	
	// for testing the generic exception handler
	
	/*
	@GetMapping("/test-exception")
	public String testException() {
		
		throw new RuntimeException("Test exception");
	}
	*/
}
