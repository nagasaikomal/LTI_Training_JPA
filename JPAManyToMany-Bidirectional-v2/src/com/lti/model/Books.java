package com.lti.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Books {

	@Id
	@Column(name="ISBN")
	private int ISBN;
	@Column(name="title")
	private String title;
	@Column(name="price")
	private int price;
	
	@ManyToMany(mappedBy="books")
	private List<Authors> authors;
	
	
	public Books() {
		super();
	}

	public Books(int iSBN, String title, int price) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.price = price;
		this.authors = authors;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	
	public List<Authors> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Authors> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Books [ISBN=" + ISBN + ", title=" + title + ", price=" + price + ", authors=" + authors + "]";
	}
	
	
	
}
