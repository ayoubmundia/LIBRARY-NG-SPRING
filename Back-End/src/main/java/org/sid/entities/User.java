package org.sid.entities;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_ACCOUNT",discriminatorType = DiscriminatorType.STRING,length = 3)
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String first_name;
	private String last_name;
	private String mail;
	private Date date ;
	private String image;
	
	private String password;
	
	@Column(length = 512)
	private String biblio;
	
	@OneToMany(mappedBy="user")
	private Collection<Operation> operations;

	public User() {
		super();
	}

	public User(String first_name, String last_name, String mail, Date date, String image, String password,
			String biblio, Collection<Operation> operations) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.mail = mail;
		this.date = date;
		this.image = image;
		this.password = password;
		this.biblio = biblio;
		this.operations = operations;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBiblio() {
		return biblio;
	}

	public void setBiblio(String biblio) {
		this.biblio = biblio;
	}

	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
