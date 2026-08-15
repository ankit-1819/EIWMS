package com.eiwms.mapper;

import org.springframework.stereotype.Component;

import com.eiwms.dto.EmployeeRequestDTO;
import com.eiwms.dto.EmployeeResponseDTO;
import com.eiwms.entity.Employee;

@Component
public class EmployeeMapper {

	public Employee toEntity(EmployeeRequestDTO dto) {
		
		Employee employee = new Employee();
		
		employee.setName(dto.getName());
		employee.setEmail(dto.getEmail());
		employee.setDepartment(dto.getDepartment());
		employee.setDesignation(dto.getDesignation());
		employee.setSalary(dto.getSalary());
		
		return employee;
		
	}
	
	public EmployeeResponseDTO toResponseDTO(Employee employee) {
		
		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
		
		employeeResponseDTO.setId(employee.getId());
		employeeResponseDTO.setName(employee.getName());
		employeeResponseDTO.setEmail(employee.getEmail());
		employeeResponseDTO.setDesignation(employee.getDesignation());
		employeeResponseDTO.setDepartment(employee.getDepartment());
		
		return employeeResponseDTO;
		
	}
}
