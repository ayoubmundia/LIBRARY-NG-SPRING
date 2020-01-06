package org.sid;

import java.util.Date;

import org.sid.dao.BookRepository;
import org.sid.dao.CategoryRepository;
import org.sid.dao.DemandeRepository;
import org.sid.dao.UserRepository;
import org.sid.entites.Book;
import org.sid.entites.Category;
import org.sid.entites.Demande;
import org.sid.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Library1Application implements CommandLineRunner {
	
	@Autowired
	private BookRepository bookRepository;
	
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
		C1.setTitle("1984");
		C1.setActive(true);
		
		Category C2 = new Category();
		C2.setTitle("Revange");
		C2.setActive(false);
		
		Category C3 = new Category();
		C3.setTitle("Sapiens");
		C3.setActive(true);
		
		Book B1 = new Book();
		B1.setAuthor("Ahmed");
		B1.setTitle("livre-1");
		B1.setDescription("Description-1");
		B1.setAvailable(true);
		B1.setCategory(C1);
		B1.setEdition("edition1");
		B1.setImage("image1");
		B1.setQuantite(100);
		B1.setDate_publication(new Date("2012/11/21"));
		
		Book B2 = new Book();
		B2.setAuthor("Alaa");
		B2.setTitle("livre-2");
		B2.setDescription("Description-2");
		B2.setAvailable(false);
		B2.setCategory(C2);
		B2.setEdition("edition2");
		B2.setImage("image2");
		B2.setQuantite(10);
		B2.setDate_publication(new Date("2011/11/11"));
		
		Book B3 = new Book();
		B3.setAuthor("Akil");
		B3.setTitle("livre-3");
		B3.setDescription("Description-3");
		B3.setAvailable(true);
		B3.setCategory(C3);
		B3.setEdition("edition3");
		B3.setImage("image3");
		B3.setQuantite(1000);
		B3.setDate_publication(new Date("2000/10/10"));
		
		Demande D1 = new Demande();
		D1.setFirst_name("use1");
		D1.setLast_name("last1");
		D1.setMail("maild1@m.com");
		D1.setDate(new Date("1998/11/11"));
		D1.setPassword("password2");
		
		Demande D2 = new Demande();
		D2.setFirst_name("use2");
		D2.setLast_name("last2");
		D2.setMail("maild2@m.com");
		D2.setDate(new Date("1998/11/11"));
		D2.setPassword("password");
		
		
		Demande D3 = new Demande();
		D3.setFirst_name("use3");
		D3.setLast_name("last3");
		D3.setMail("maild3@m.com");
		D3.setDate(new Date("1998/11/11"));
		D3.setPassword("passworsssd");
		
		User U1 = new User();
		U1.setFirst_name("google");
		U1.setLast_name("lastgoogle");
		U1.setMail("mailu1@m.com");
		U1.setPassword("1233");
		U1.setBiblio("sssbiibil");
		
		User U2 = new User();
		U2.setFirst_name("gossogle");
		U2.setLast_name("lastgoogle");
		U2.setMail("mailu2@m.com");
		U2.setPassword("233");
		U2.setBiblio("biibil");
		
		User U3 = new User();
		U3.setFirst_name("faile");
		U3.setLast_name("lastgoogle");
		U3.setMail("mailu3@m.com");
		U3.setPassword("123");
		U3.setBiblio("224544");
		
		categoryRepository.save(C1);
		categoryRepository.save(C2);
		categoryRepository.save(C3);
		
		bookRepository.save(B1);
		bookRepository.save(B2);
		bookRepository.save(B3);
		
		demandeRepository.save(D1);
		demandeRepository.save(D2);
		demandeRepository.save(D3);
		
		userRepository.save(U1);
		userRepository.save(U2);
		userRepository.save(U3);
		
	}

}
