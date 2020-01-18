package com.lti.ui;


import java.util.List;
import java.util.Scanner;

import com.lti.model.Employee;
import com.lti.service.EmployeeService;
import com.lti.service.EmployeeServiceImpl;

public class Main {

	public static void main(String[] args) {
	
		EmployeeService service =new EmployeeServiceImpl();
		Scanner scanner=new Scanner(System.in);
		boolean flag=true;
		do{
		System.out.println("1. Find All Employees");
		System.out.println("2. Find Employees By Salary");
		System.out.println("3. Find Employees By department id");
		System.out.println("4. Find Employees By department Name");
		System.out.println("5. Find Employees whose salary > employee's Salary");
		
		System.out.println("0.Exit");
		int choice=scanner.nextInt();

		switch(choice){
		case 1:
			List<Employee> employees= service.findAllEmployees();
			displayEmployees(employees);
			break;
		case 2:
			System.out.println("Enter Salary:");
			double sal=scanner.nextDouble();
			 employees=service.findEmployeesBySalary(sal);
			displayEmployees(employees);
			break;
		case 3:
			System.out.println("enter departmentId:");
			int dept=scanner.nextInt();
			employees=service.findEmployeesByDepartmentId(dept);
			displayEmployees(employees);
			break;
		case 4:
			System.out.println("enter departmentName:");
			String deptName=scanner.next();
			employees=service.findEmployeesByDepartmentName(deptName);
			displayEmployees(employees);
			break;
			
		case 5:
			System.out.println("enter EmployeeName: ");
			String empName=scanner.next();
			employees=service.findEmployeesByEmployeeName(empName);
			displayEmployees(employees);
			break;
			
				
		case 0:
			flag=false;
		}
		
		}while(flag);
		System.out.println("====== End of the Application =====");
	
	}

	
	public static void displayEmployees(List<Employee> employees){
	   for(Employee emp : employees){
		   System.out.println("Employee Id: "+emp.getEmployeeId());
		   System.out.println("Employee Name"+emp.getEmployeeName());
		   System.out.println("Employee Salary"+emp.getEmployeeSalary());
		   System.out.println("Department Id:"+emp.getDepartment().getDepartmentId());
		   System.out.println("Department Nmae:"+emp.getDepartment().getDepartmentName());
		   
	   }
		
	}
}
