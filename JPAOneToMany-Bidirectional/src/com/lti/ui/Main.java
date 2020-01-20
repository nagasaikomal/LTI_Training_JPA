package com.lti.ui;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Department;
import com.lti.model.Employee;



public class Main {

	public static void main(String[] args) {
       
         
         EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA_PU");
         EntityManager entityManager=factory.createEntityManager();         
 	     
         entityManager.getTransaction().begin();
         
         Department dept1=new Department(10,"Development");
         Employee emp1=new Employee(100,"Rohan",7500);
         Employee emp2=new Employee(101,"Sushmita",7000);
         emp1.setDepartment(dept1);
         emp2.setDepartment(dept1);
         
         
         Set<Employee> emps=new HashSet<>();
         emps.add(emp1);
         emps.add(emp2);
         dept1.setEmployee(emps);
         
         Department dept2=new Department(20,"HR");
         Employee emp3=new Employee(102,"KrishnaSai",9000);
         Employee emp4=new Employee(103,"Lavanya",10000);
         emp3.setDepartment(dept2);
         emp4.setDepartment(dept2);
         Set<Employee> emps2=new HashSet<>();
         emps2.add(emp3);
         emps2.add(emp4); 
         dept2.setEmployee(emps2);
       
         entityManager.persist(dept1);
         entityManager.persist(dept2);
         
         entityManager.getTransaction().commit();
              
         entityManager.close();
         factory.close();
	             
	}
	

} 
