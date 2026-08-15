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

import com.eiwms.dto.EmployeeRequestDTO;
import com.eiwms.dto.EmployeeResponseDTO;
import com.eiwms.dto.EmployeeUpdateDTO;
import com.eiwms.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/eiwms")
public class EiwmsController {

	private final EmployeeService employeeService;
	
	public EiwmsController(EmployeeService employeeService) {
	    super();
	    this.employeeService = employeeService;
	}


	@PostMapping
	public EmployeeResponseDTO addEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
		
		return employeeService.addEmployee(employeeRequestDTO);
	}
	
	@GetMapping
	public List<EmployeeResponseDTO> getAllEmployee(){
		
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {
		
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/{id}")
	public EmployeeResponseDTO updateEmployee(@PathVariable Long id,@Valid @RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
		
		
		return employeeService.updateEmployee(employeeUpdateDTO, id);
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
