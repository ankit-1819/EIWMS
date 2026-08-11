package com.eiwms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eiwms.entity.Employee;
import com.eiwms.exception.EmployeeNotFoundException;
import com.eiwms.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final  EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	// add employee
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
		
	}
	
	// get all employees
	public List<Employee> getAllEmployee(){
		
		return employeeRepository.findAll();
	}
	
	//get employee by Id
	public Employee getEmployeeById(Long id) {
	    return employeeRepository.findById(id)
	            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
	}
	
	//update employee
	public Employee updateEmployee(Employee employee,Long id) {
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow();
		
			existingEmployee.setName(employee.getName());
			existingEmployee.setEmail(employee.getEmail());
			existingEmployee.setDepartment(employee.getDepartment());
			existingEmployee.setDesignation(employee.getDesignation());
			existingEmployee.setSalary(employee.getSalary());
			
			return employeeRepository.save(existingEmployee);
	}
	
	//delete employee
	public void deleteEmployee(Long id) {
		
		employeeRepository.deleteById(id);
	}
	
}
