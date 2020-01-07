package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PROL")
public class Prolongation extends Operation{
	
	public Prolongation() {
		super();
	}

	public Prolongation(Date date_debut_operation, Date date_fin_operation, Book book, User user) {
		super( date_debut_operation,  date_fin_operation,  book,  user);
	}

}
