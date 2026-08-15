package com.eiwms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eiwms.dto.EmployeeRequestDTO;
import com.eiwms.dto.EmployeeResponseDTO;
import com.eiwms.dto.EmployeeUpdateDTO;
import com.eiwms.entity.Employee;
import com.eiwms.exception.EmployeeNotFoundException;
import com.eiwms.mapper.EmployeeMapper;
import com.eiwms.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final  EmployeeRepository employeeRepository;

	private final EmployeeMapper employeeMapper;
	
	public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
		super();
		this.employeeRepository = employeeRepository;
		this.employeeMapper = employeeMapper;
	}
	
	// add employee
	public EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO) {
		
		Employee employee = employeeMapper.toEntity(employeeRequestDTO);
		
		Employee savedEmployee =  employeeRepository.save(employee);
		
		EmployeeResponseDTO employeeResponseDTO = employeeMapper.toResponseDTO(savedEmployee);
		
		return employeeResponseDTO;
		
	}
	
	// get all employees
	public List<EmployeeResponseDTO> getAllEmployee(){
		
		List<Employee> employees = employeeRepository.findAll();
		
		List<EmployeeResponseDTO> responseList = new ArrayList<EmployeeResponseDTO>();
		
		for(Employee employee : employees) {
			
			EmployeeResponseDTO dto = employeeMapper.toResponseDTO(employee);
			responseList.add(dto);
		}
		
		return responseList;
	}
	
	//get employee by Id
	public EmployeeResponseDTO getEmployeeById(Long id) {
		
	    Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
	    
	    return employeeMapper.toResponseDTO(existingEmployee);
	    
	}
	
	//update employee
	public EmployeeResponseDTO updateEmployee(EmployeeUpdateDTO employeeUpdateDTO,Long id) {
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found with id: "+id));
		
			existingEmployee.setName(employeeUpdateDTO.getName());
			existingEmployee.setEmail(employeeUpdateDTO.getEmail());
			
			
		Employee savedEmployee = employeeRepository.save(existingEmployee);
		
		return employeeMapper.toResponseDTO(savedEmployee);
	}
	
	
	//delete employee
	public void deleteEmployee(Long id) {
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found with id: "+id));
		
		employeeRepository.delete(existingEmployee);
	}
	
}
