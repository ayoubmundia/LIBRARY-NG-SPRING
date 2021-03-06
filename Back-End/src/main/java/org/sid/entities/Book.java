package org.sid.entities;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Book {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_book;
	
	private String author;
	private String title;
	private String edition;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date_publication;
	
	private boolean isAvailable = true;
	private String image;
	private int quantite;
	
	@Column(length=512)
	private String description;
	
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy="book")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Operation> operations;

	public Book() {
		super();
	}

	public Book(String author, String title, String edition, Date date_publication, boolean isAvailable, String image,
			int quantite, String description, Category category, Collection<Operation> ops) {
		super();
		this.author = author;
		this.title = title;
		this.edition = edition;
		this.date_publication = date_publication;
		this.isAvailable = isAvailable;
		this.image = image;
		this.quantite = quantite;
		this.description = description;
    	this.category = category;
		this.operations = ops;
	}

	public Long getId_book() {
		return id_book;
	}

	public void setId_book(Long id_book) {
		this.id_book = id_book;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Date getDate_publication() {
		return date_publication;
	}

	public void setDate_publication(Date date_publication) {
		this.date_publication = date_publication;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Collection<Operation> getOperations() {
		return this.operations ;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

}