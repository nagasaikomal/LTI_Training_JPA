package com.lti.service;

import java.util.List;

import com.lti.model.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployees();
	public List<Employee> findEmployeesBySalary(double salary);	
	public List<Employee> findEmployeesByDepartmentId(int dept);	
	public List<Employee> findEmployeesByDepartmentName(String deptName);
	public List<Employee> findEmployeesByEmployeeName(String empName);
	
}
