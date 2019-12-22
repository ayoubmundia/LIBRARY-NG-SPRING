package org.sid;

//import org.sid.dao.BookRepository;
import org.sid.dao.CategoryRepository;
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

	//@Autowired
	//private BookRepository bookRepository;
	
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
		
		categoryRepository.save(C1);
		categoryRepository.save(C2);
		categoryRepository.save(C3);
	}

}
