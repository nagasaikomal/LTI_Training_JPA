package com.lti.dao;

import java.util.List;

import com.lti.model.Employee;

public interface EmployeeDao {

	public List<Employee> readAllEmployee();
	public List<Employee> readEmployeesBySalary(double salary);
	public List<Employee> readEmployeesByDepartmentId(int dept);
	public List<Employee> readEmployeesByDepartmentName(String deptName);
	public List<Employee> readEmployeesByEmpName(String empName);
}
