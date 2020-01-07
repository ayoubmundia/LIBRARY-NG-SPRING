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

	public Emprunt(Date date_debut_operation, Date date_fin_operation, Book book, User user) {
		super(date_debut_operation, date_fin_operation, book, user);
		
	}

	
	
}
