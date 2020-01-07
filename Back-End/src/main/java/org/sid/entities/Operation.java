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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OPE",discriminatorType = DiscriminatorType.STRING,length = 3)
public class Operation {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_operation;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date_debut_operation;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date_fin_operation;
	
	@ManyToOne
	@JoinColumn(name="ID_BOOK")
	private Book book;

	@ManyToOne
	@JoinColumn(name="ID_USER")
	private User user;

	public Operation() {
		super();
	}

	public Operation(Date date_debut_operation, Date date_fin_operation, Book book, User user) {
		super();
		this.date_debut_operation = date_debut_operation;
		this.date_fin_operation = date_fin_operation;
		this.book = book;
		this.user = user;
	}


	public Long getId_operation() {
		return id_operation;
	}

	public void setId_operation(Long id_operation) {
		this.id_operation = id_operation;
	}


	

	public Date getDate_debut_operation() {
		return date_debut_operation;
	}


	public void setDate_debut_operation(Date date_debut_operation) {
		this.date_debut_operation = date_debut_operation;
	}


	public Date getDate_fin_operation() {
		return date_fin_operation;
	}


	public void setDate_fin_operation(Date date_fin_operation) {
		this.date_fin_operation = date_fin_operation;
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
