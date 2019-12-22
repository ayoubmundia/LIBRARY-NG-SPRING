package org.sid.entities;

import java.util.Collection;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("USR")
public class Member extends User {

	public Member() {
		super();
	}

	public Member(String first_name, String last_name, String mail, Date date, String image, String biblio,
			Collection<Operation> operations) {
		super(first_name, last_name, mail, date, image, biblio, operations);
	}
	
}
