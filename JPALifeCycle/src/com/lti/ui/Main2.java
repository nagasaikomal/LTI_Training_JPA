package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;

public class Main2 {

	public static void main(String[] args) {
			//New State
	        Student student=new Student(100, "Makarand",66.5);
	        
	        
	        EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA_PU");
	        EntityManager entityManager=factory.createEntityManager();         
		    entityManager.getTransaction().begin();
		    // Attached or Managed
		    entityManager.persist(student);
		    entityManager.getTransaction().commit();

	}

}
