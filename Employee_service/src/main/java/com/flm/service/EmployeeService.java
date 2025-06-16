package com.flm.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.flm.entity.Employee;
import com.flm.exception.EmployeeNotFoundException;
import com.flm.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	
	private final EmployeeRepository employeerepository;
	
	
	public Employee saveEmployee(Employee Employee ) {
		return employeerepository.save(Employee);
	}
public Employee getEmployee(Long id) throws EmployeeNotFoundException {
		Optional<Employee> optdept = employeerepository.findById(id);
		if(optdept.isPresent()) return optdept.get();
		throw new EmployeeNotFoundException("Employee is not found");
	}
}
