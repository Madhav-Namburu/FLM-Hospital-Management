package com.flm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flm.dto.EmployeeForm;
import com.flm.entity.Employee;
import com.flm.exception.EmployeeNotFoundException;
import com.flm.service.EmployeeService;
import com.flm.util.Converter;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	private final Converter converter;

	@PostMapping("/saveEmployee")
	public EmployeeForm saveEmployee(@RequestBody EmployeeForm employeeform) {
		Employee emp = converter.getEmployee(employeeform);
		emp= employeeService.saveEmployee(emp);
		EmployeeForm empf = converter.getEmployeefrom(emp);
		return empf;

	}

	@GetMapping("/getemployee/{id}")
	public EmployeeForm getEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
		Employee emp = employeeService.getEmployee(id);
		EmployeeForm empf = EmployeeForm.builder()
				.id(emp.getId())
				.name(emp.getName())
				.address(emp.getAddress())
				.deptid(emp.getDeptid())
				.build();
		return empf;
	}

}
