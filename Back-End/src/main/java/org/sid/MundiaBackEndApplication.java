package org.sid;

import org.sid.dao.BookRepository;
//import org.sid.dao.BookRepository;
import org.sid.dao.CategoryRepository;
import org.sid.entities.Book;
//import org.sid.dao.OperationRepository;
//import org.sid.dao.UserRepository;
//import org.sid.entities.Book;
import org.sid.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MundiaBackEndApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;
	
	//@Autowired
	//private OperationRepository operationRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	//@Autowired
	//private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MundiaBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category C1 = new Category();
		C1.setTitle("1984");
		
		Category C2 = new Category();
		C2.setTitle("Revange");
		
		Category C3 = new Category();
		C3.setTitle("Sapiens");
		
		Book B1 = new Book();
		B1.setAuthor("Ahmed");
		B1.setTitle("livre-1");
		B1.setDescription("Description-1");
		B1.setAvailable(true);
		B1.setCategory(C1);
		
		Book B2 = new Book();
		B2.setAuthor("Alaa");
		B2.setTitle("livre-2");
		B2.setDescription("Description-2");
		B2.setAvailable(false);
		B2.setCategory(C2);
		
		Book B3 = new Book();
		B3.setAuthor("Akil");
		B3.setTitle("livre-3");
		B3.setDescription("Description-3");
		B3.setAvailable(true);
		B3.setCategory(C3);
		
		categoryRepository.save(C1);
		categoryRepository.save(C2);
		categoryRepository.save(C3);
		
		bookRepository.save(B1);
		bookRepository.save(B2);
		bookRepository.save(B3);
	}

}
