package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RES")
public class Reservation extends Operation {

	public Reservation() {
		super();
	}

	public Reservation(Date date_debut_operation, Date date_fin_operation, Book book, User user) {
		super(date_debut_operation, date_fin_operation, book, user);
		
	}

	
	
}
