package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Address;
import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {
         Student student=new Student(12, "Makarand",66.5);
         Address address=new Address(10, "Mumbai", "400001");
         student.setAddress(address);
         
         EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA_PU");
         EntityManager entityManager=factory.createEntityManager();         
 	     
         entityManager.getTransaction().begin();
         entityManager.persist(student);
         entityManager.persist(address);
         entityManager.getTransaction().commit();
              
         entityManager.close();
         factory.close();
	             
	}
	

} 
