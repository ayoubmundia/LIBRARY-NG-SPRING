package org.sid;

import java.util.Date;

import org.sid.dao.BookRepository;
import org.sid.dao.CategoryRepository;
import org.sid.dao.DemandeRepository;
import org.sid.dao.OperationRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Book;
import org.sid.entities.Category;
import org.sid.entities.Demande;
import org.sid.entities.Emprunt;
import org.sid.entities.Operation;
import org.sid.entities.Prolongation;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Library1Application implements CommandLineRunner {
	
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DemandeRepository demandeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Library1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Library Back End On Fire!!");
		
		Category C1 = new Category();
		C1.setTitle("Self-help Book");
		C1.setActive(true);
		
		Category C2 = new Category();
		C2.setTitle("Short Story");
		C2.setActive(false);
		
		Category C3 = new Category();
		C3.setTitle("Classic");
		C3.setActive(true);
		
		Book B1 = new Book();
		B1.setAuthor("Malcolm Gladwell");
		B1.setTitle("Outliers: The Story of Success");
		B1.setDescription("In this stunning new book, Malcolm Gladwell takes us on an intellectual journey through the world of \"outliers\"--the best and the brightest, the most famous and the most successful. He asks the question: what makes high-achievers different?");
		B1.setAvailable(true);
		B1.setCategory(C1);
		B1.setEdition("Published November 18th 2008 by Little, Brown and Company");
		B1.setImage("bookImage1");
		B1.setQuantite(100);
		B1.setDate_publication(new Date("2012/11/21"));
		
		Book B2 = new Book();
		B2.setAuthor("Yuval Noah Harari");
		B2.setTitle("Sapiens: A Brief History of Humankind");
		B2.setDescription("100,000 years ago, at least six human species inhabited the earth. Today there is just one. Us. Homo sapiens.");
		B2.setAvailable(false);
		B2.setCategory(C2);
		B2.setEdition("Published 2014 by Harvill Secker");
		B2.setImage("bookImage2");
		B2.setQuantite(10);
		B2.setDate_publication(new Date("2011/11/11"));
		
		Book B3 = new Book();
		B3.setAuthor("George Orwell");
		B3.setTitle("1984");
		B3.setDescription("Among the seminal texts of the 20th century, Nineteen Eighty-Four is a rare work that grows more haunting as its futuristic purgatory becomes more real. Published in 1949, the book offers political satirist George Orwell's nightmarish vision of a totalitarian, bureaucratic world and one poor stiff's attempt to find individuality.");
		B3.setAvailable(true);
		B3.setCategory(C3);
		B3.setEdition("Published September 3rd 2013 by Houghton Mifflin Harcourt");
		B3.setImage("bookImage3");
		B3.setQuantite(1000);
		B3.setDate_publication(new Date("2000/07/10"));
		
		Book B4 = new Book();
		B4.setAuthor("Bryan Cranston");
		B4.setTitle("A Life in Parts");
		B4.setDescription("A poignant, intimate, funny, inspiring memoir—both a coming-of-age story and a meditation on creativity, devotion, and craft—from Bryan Cranston, beloved and acclaimed star of one of history’s most successful TV shows, Breaking Bad.");
		B4.setAvailable(true);
		B4.setCategory(C2);
		B4.setEdition("Published October 11th 2016 by Scribner");
		B4.setImage("bookImage4");
		B4.setQuantite(19);
		B4.setDate_publication(new Date("1998/10/10"));
		
		Demande D1 = new Demande();
		D1.setFirst_name("Charif");
		D1.setLast_name("Gaber");
		D1.setMail("AllahMyGod@gmail.com");
		D1.setDate(new Date("2020/01/01"));
		D1.setPassword("HoHoHo");
		
		Demande D2 = new Demande();
		D2.setFirst_name("Hamouda");
		D2.setLast_name("Hamou");
		D2.setMail("hamouda@outlook.com");
		D2.setDate(new Date("2020/01/11"));
		D2.setPassword("hahahaha");
		
		
		Demande D3 = new Demande();
		D3.setFirst_name("Asmar");
		D3.setLast_name("El sassi");
		D3.setMail("el_sassi@mundiapolis.ma");
		D3.setDate(new Date("2020/01/12"));
		D3.setPassword("lalala");
		
		Demande D4 = new Demande();
		D4.setFirst_name("Hicham");
		D4.setLast_name("Noustik");
		D4.setMail("h.noustik@outlook.com");
		D4.setDate(new Date("2020/01/13"));
		D4.setPassword("Tamalhada");
		
		User U1 = new User();
		U1.setFirst_name("Achraf");
		U1.setLast_name("El kadissi");
		U1.setMail("a.el_kadissi@mundiapolis.ma");
		U1.setPassword("123456");
		U1.setBiblio("Student At Mundiapolis University");
		
		User U2 = new User();
		U2.setFirst_name("Ahlam");
		U2.setLast_name("Moutawakil");
		U2.setMail("a.moutawakil@mundiapolis.ma");
		U2.setPassword("123456");
		U2.setBiblio("Student At Mundiapolis University");

		
		Emprunt O1= new Emprunt();
		O1.setBook(B1);
		O1.setUser(U1);
		O1.setDate_debut_operation(new Date("2000/10/10"));
		O1.setDate_fin_operation(new Date("2000/10/10"));
		
		Prolongation O2= new Prolongation();
		O1.setBook(B1);
		O1.setUser(U1);
		O1.setDate_debut_operation(new Date("2000/10/10"));
		O1.setDate_fin_operation(new Date("2000/10/10"));
//		
//		User U2 = new User();
//		U2.setFirst_name("gossogle");
//		U2.setLast_name("lastgoogle");
//		U2.setMail("mailu2@m.com");
//		U2.setPassword("233");
//		U2.setBiblio("biibil");
		
		
		categoryRepository.save(C1);
		categoryRepository.save(C2);
		categoryRepository.save(C3);
		
		bookRepository.save(B1);
		bookRepository.save(B2);
		bookRepository.save(B3);
		bookRepository.save(B4);
		
		demandeRepository.save(D1);
		demandeRepository.save(D2);
		demandeRepository.save(D3);
		demandeRepository.save(D4);
		
		userRepository.save(U1);
		userRepository.save(U2);
		
		operationRepository.save(O1);
//		operationRepository.save(O2);
	}

}
