package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OPE",discriminatorType = DiscriminatorType.STRING,length = 3)
public class Operation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_operation;
	
	private Date date_operation;
	
	@ManyToOne
	@JoinColumn(name="ID_BOOK")
	private Book book;

	@ManyToOne
	@JoinColumn(name="ID_USER")
	private User user;

	public Operation() {
		super();
	}

	public Operation(Date date_operation, Book book, User user) {
		super();
		this.date_operation = date_operation;
		this.book = book;
		this.user = user;
	}

	public long getId_operation() {
		return id_operation;
	}

	public void setId_operation(long id_operation) {
		this.id_operation = id_operation;
	}

	public Date getDate_operation() {
		return date_operation;
	}

	public void setDate_operation(Date date_operation) {
		this.date_operation = date_operation;
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
