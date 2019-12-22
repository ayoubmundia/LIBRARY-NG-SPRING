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

	public Reservation(Date date_operation, Book book, User user) {
		super(date_operation, book, user);
	}
	
}
