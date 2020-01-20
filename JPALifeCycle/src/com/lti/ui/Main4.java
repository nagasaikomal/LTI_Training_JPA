package com.lti.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.Student;

public class Main4 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager=factory.createEntityManager();
		
		Query query= entityManager.createQuery("From Student");
		List<Student> list= query.getResultList();
		for(Student s: list){
			System.out.println(s);
		}
		
		TypedQuery<Student> tquery = entityManager.createQuery("FROM Student", Student.class);
		List<Student> list2= tquery.getResultList();
		for(Student s: list2){
			System.out.println(s);
		}
		
		entityManager.close();
		factory.close();

	}

}
