package com.eiwms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiwms.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
