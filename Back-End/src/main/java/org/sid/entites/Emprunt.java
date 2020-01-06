package org.sid.entites;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Emprunt{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_emprunt;

	private Date date_emprunt;

	@ManyToOne
	private Book book;

	@ManyToOne
	private User user;

	public Emprunt() {
		super();
	}

	public Emprunt(Date date, Book book, User user) {
		super();
		this.date_emprunt = date;
		this.book = book;
		this.user = user;
	}

	public long getId_operation() {
		return id_emprunt;
	}

	public void setId_operation(long id) {
		this.id_emprunt = id;
	}

	public Date getDate_operation() {
		return date_emprunt;
	}

	public void setDate_operation(Date date) {
		this.date_emprunt = date;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
