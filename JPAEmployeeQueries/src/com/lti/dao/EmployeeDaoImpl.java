package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.lti.model.Employee;
import com.lti.utils.JpaUtils;

public class EmployeeDaoImpl implements EmployeeDao {
	private EntityManager entityManager;
    private final static String GET_ALL_EMPLOYEES ="Select e From Employee e";
    private final static String GET_EMPLOYEES_BY_SALARY="Select e From Employee e Where e.employeeSalary > :salary";
    private final static String GET_EMPLOYEES_BY_DEPTID="select e From Employee e join e.department d Where d.departmentId= :dept";
    private final static String GET_EMPLOYEES_BY_DEPTNAME="select e From Employee e join e.department d Where d.departmentName= :deptName";
    private final static String GET_EMPLOYEES_BY_EMPNAME="select e from Employee e where e.employeeSalary >(select f.employeeSalary from Employee f where f.employeeName= :empName)";
    
	public EmployeeDaoImpl(){
		entityManager=JpaUtils.getEntityManager();
	}
    
    @Override
	public List<Employee> readAllEmployee() {
    	TypedQuery<Employee> tquery=entityManager.createQuery(GET_ALL_EMPLOYEES,Employee.class);
    	List<Employee> result=tquery.getResultList();
		return result;
	}

	@Override
	public List<Employee> readEmployeesBySalary(double salary) {
	    TypedQuery<Employee> tquery=entityManager.createQuery(GET_EMPLOYEES_BY_SALARY, Employee.class);
	    tquery.setParameter("salary", salary);
	    List<Employee> result=tquery.getResultList();
		return result;
	}

	@Override
	public List<Employee> readEmployeesByDepartmentId(int dept) {
		TypedQuery<Employee> tquery=entityManager.createQuery(GET_EMPLOYEES_BY_DEPTID, Employee.class);
	    tquery.setParameter("dept", dept);
	    List<Employee> result=tquery.getResultList();
		return result;
		
	}

	@Override
	public List<Employee> readEmployeesByDepartmentName(String deptName) {
		
		TypedQuery<Employee> tquery=entityManager.createQuery(GET_EMPLOYEES_BY_DEPTNAME, Employee.class);
	    tquery.setParameter("deptName", deptName);
	    List<Employee> result=tquery.getResultList();
		return result;
	}

	@Override
	public List<Employee> readEmployeesByEmpName(String empName) {
		TypedQuery<Employee> tquery=entityManager.createQuery(GET_EMPLOYEES_BY_EMPNAME, Employee.class);
	    tquery.setParameter("empName", empName);
	    List<Employee> result=tquery.getResultList();
		return result;
		
	}

}
