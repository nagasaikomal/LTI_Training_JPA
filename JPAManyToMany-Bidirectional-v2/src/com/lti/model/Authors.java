package com.lti.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Authors {
	
	@Id
	@Column(name="author_id")
	private int authorId;
	@Column(name="author_name")
	private String authorName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Book_Author",
			   joinColumns={@JoinColumn(name="author_id")},
			   inverseJoinColumns={@JoinColumn(name="ISBN")})
	
	private List<Books> books;
	
	public Authors() {
		super();
	}

	public Authors(int authorId, String authorName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Authors [authorId=" + authorId + ", authorName=" + authorName + ", books=" + books + "]";
	}
	
	
	
	

}
