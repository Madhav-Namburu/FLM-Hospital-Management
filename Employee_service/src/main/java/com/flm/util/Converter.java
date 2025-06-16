package com.flm.util;

import org.springframework.stereotype.Component;

import com.flm.dto.EmployeeForm;
import com.flm.entity.Employee;

@Component
public class Converter {

	public Employee getEmployee(EmployeeForm employeeform) {
		return Employee.builder().name(employeeform.getName()).address(employeeform.getAddress())
				.salary(employeeform.getSalary()).deptid(employeeform.getDeptid()).build();

	}

	public EmployeeForm getEmployeefrom(Employee emp) {
		return EmployeeForm.builder().id(emp.getId()).name(emp.getName()).address(emp.getAddress())
				.deptid(emp.getDeptid()).build();

	}
}
