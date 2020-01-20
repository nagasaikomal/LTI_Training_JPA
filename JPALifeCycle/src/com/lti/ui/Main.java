package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {
		//New State
         Student student=new Student(15, "krishna",66.5);
         EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA_PU");
              EntityManager entityManager=factory.createEntityManager();         
 	          entityManager.getTransaction().begin();
 	          // Attached or Managed
              entityManager.persist(student);
              entityManager.getTransaction().commit();
              
              // Attached or Managed
              Student student2=entityManager.find(Student.class, student.getRollNumber());//we should give primary key value
              System.out.println(student2);
           
              //detatched
              entityManager.clear();
              
              
              entityManager.getTransaction().begin();
              student.setStudentName("makarand bhoir");
              entityManager.merge(student);
              entityManager.getTransaction().commit();
              
           // Attached or Managed
              student2=entityManager.find(Student.class, student.getRollNumber());//we should give primary key value
              System.out.println(student2);
              
              
              entityManager.getTransaction().begin();
              // removed
              entityManager.remove(student2);
              entityManager.getTransaction().commit();
              
              student2=entityManager.find(Student.class, student.getRollNumber());
              System.out.println(student2);
	             
	}
	

} 
