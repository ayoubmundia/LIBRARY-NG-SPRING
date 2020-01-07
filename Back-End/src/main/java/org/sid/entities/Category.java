package org.sid.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Category {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_category;
	
	private String title;
	private boolean active;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy="category")
	private Collection<Book> books;

	public Category(String title, boolean active ,Collection<Book> books) {
		super();
		this.title = title;
		this.books = books;
		this.active = true;
	}

	public Category() {
		super();
	}

	public Long getId_category() {
		return id_category;
	}

	public void setId_category(Long id_category) {
		this.id_category = id_category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
