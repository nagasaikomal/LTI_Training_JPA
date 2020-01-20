package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Address;
import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {
         Student student=new Student(12, "Makarand",66.5);
         Address address=new Address("Mumbai", "400001");
         student.setAddress(address);
         
         Student student2=new Student(13, "Komal",66.5);
         Address address2=new Address("Hyderabad", "500001");
         student2.setAddress(address2);
         
         EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA_PU");
         EntityManager entityManager=factory.createEntityManager();         
 	     
         entityManager.getTransaction().begin();
         
         entityManager.persist(student);
         //entityManager.persist(address);
         
         entityManager.persist(student2);
         //entityManager.persist(address2);
         
         
         entityManager.getTransaction().commit();
              
         entityManager.close();
         factory.close();
	             
	}
	

} 
