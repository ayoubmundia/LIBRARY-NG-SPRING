package org.sid.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Demande {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_demande;
	
	private String first_name;
	private String last_name;
	private String mail;
	private String password;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date ;

	public Demande() {
		super();
	}

	public Demande(String first_name, String last_name, String mail, Date date,String password) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.mail = mail;
		this.date = date;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId_demande() {
		return id_demande;
	}

	public void setId_demande(Long id_demande) {
		this.id_demande = id_demande;
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
	
}
