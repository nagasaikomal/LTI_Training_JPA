package com.lti.ui;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Authors;
import com.lti.model.Books;

public class Main1 {
	
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	
	static{
		factory = Persistence.createEntityManagerFactory("JPA_PU");
		entityManager = factory.createEntityManager();
	}
	
	public static void loadData(){
		 Books book1=new Books();
         book1.setISBN(1);
         book1.setTitle("Harry Potter");
         book1.setPrice(250);
         
         Books book2=new Books();
         book2.setISBN(2);
         book2.setTitle("Secret");
         book2.setPrice(350);
         
         Books book3=new Books();
         book3.setISBN(3);
         book3.setTitle("Half girlfriend");
         book3.setPrice(150);
         
         Authors author1=new Authors();
         author1.setAuthorId(1001);
         author1.setAuthorName("Komal");
         List<Books> list1=new ArrayList<>();
         list1.add(book3);
         list1.add(book2);
         author1.setBooks(list1);
         
         Authors author2=new Authors();
         author2.setAuthorId(1002);
         author2.setAuthorName("Rohan");
         List<Books> list2=new ArrayList<>();
         list2.add(book1);
         author2.setBooks(list2);
		
		 
        entityManager.getTransaction().begin();
        
        entityManager.persist(author1);
        entityManager.persist(author2);
       
        
        entityManager.getTransaction().commit();
		
		
	}
	
	public static void main(String[] args ) {
		loadData();
		
		String jpql="Select b from Authors b";
		TypedQuery<Authors> tquery = entityManager.createQuery(jpql, Authors.class);
		List<Authors> result=tquery.getResultList();
		
		for(Authors b1: result){
			System.out.println("Author Id: "+b1.getAuthorId());
			System.out.println("Author name: "+b1.getAuthorName());
			
		
   		List<Books> books = b1.getBooks();
		for (Books books2 : books) {
			
		
			
			System.out.println("Book ISBN: "+books2.getISBN());
			System.out.println("Book Price: "+books2.getPrice());
			System.out.println("Book name: "+books2.getTitle());
			System.out.println("--------------------------------------");
		}
//    		
//			
//		}
		
		
	}
	}

}
