package com.lti.ui;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Authors;
import com.lti.model.Books;

public class Main2 {
	
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
		
		String jpql="Select b from Books b";
		TypedQuery<Books> tquery = entityManager.createQuery(jpql, Books.class);
		List<Books> result=tquery.getResultList();
		
		for(Books b1: result){
			System.out.println("Books Id: "+b1.getISBN());
			System.out.println("Book name: "+b1.getTitle());
			System.out.println("Book Price: "+b1.getPrice());
			
		
   		/*List<Authors> books = b1.getAuthors();
		for (Authors books2 : books) {
			
		
			
			System.out.println("Book ISBN: "+books2.getAuthorId());
			System.out.println("Book Price: "+books2.getAuthorName());
			//System.out.println("Book name: "+books2.getTitle());
			System.out.println("--------------------------------------");
		}
   		*/

		
		
	}
	}

}
