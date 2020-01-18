package com.lti.service;

import java.util.List;

import com.lti.dao.EmployeeDao;
import com.lti.dao.EmployeeDaoImpl;
import com.lti.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;
    public EmployeeServiceImpl(){
    	employeeDao=new EmployeeDaoImpl();
    }
	
    
    @Override
	public List<Employee> findAllEmployees() {
		List<Employee> result=employeeDao.readAllEmployee();

		return result;
	}


	@Override
	public List<Employee> findEmployeesBySalary(double salary) {

         
		return employeeDao.readEmployeesBySalary(salary);
	}


	@Override
	public List<Employee> findEmployeesByDepartmentId(int dept) {
		return employeeDao.readEmployeesByDepartmentId(dept);
	}


	@Override
	public List<Employee> findEmployeesByDepartmentName(String deptName) {
		return employeeDao.readEmployeesByDepartmentName(deptName);
	}


	@Override
	public List<Employee> findEmployeesByEmployeeName(String empName) {
		return employeeDao.readEmployeesByEmpName(empName);
	}

}
