package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EMP")
public class Emprunt extends Operation {

	public Emprunt() {
		super();
	}

	public Emprunt(Date date_operation, Book book, User user) {
		super(date_operation, book, user);
	}
	
}
