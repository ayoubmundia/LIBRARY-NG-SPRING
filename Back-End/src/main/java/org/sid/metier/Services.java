package org.sid.metier;

import java.util.List;
import java.util.Optional;

import org.sid.dao.BookRepository;
import org.sid.dao.CategoryRepository;
import org.sid.dao.DemandeRepository;
import org.sid.dao.EmpruntRepository;
import org.sid.dao.UserRepository;
import org.sid.entites.Book;
import org.sid.entites.Category;
import org.sid.entites.Demande;
import org.sid.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class Services implements IServices {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DemandeRepository demandeRepository;
	
	@Autowired
	private EmpruntRepository empruntRepository;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.get();
	}
	
	//Category Services Implimentation
	
	@Override
	public List<Book> getBookOfCategory(Long id) {
		return (List<Book>) categoryRepository.findById(id).get().getBooks();
	}

	@Override
	public Page getAllCategoriesPage(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategoryById(Long id, Category category) {
		Category C = categoryRepository.findById(id).get();
		C.setId_category(id);
		return categoryRepository.save(C);
	}

	@Override
	public void deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);
		
	}

	//Books Services Implimentation
	
	@Override
	public Page<Book> getBookOfCategoryPage(Long id, Pageable page ) {
		//Pageable p = PageRequest.of(page, size);
		List<Book> list = (List<Book>) categoryRepository.findById(id).get().getBooks();
		Page<Book> pages = new PageImpl<Book>(list, page, list.size());
		return pages ;
	}
	
	//User Services Implimentation
	
	@Override
	public User findUserByMailAndPassword(String mail, String password) {
		return userRepository.listloginUser(mail, password);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	//Demande Services Implimentation
	
	@Override
	public Demande addDemande(Demande demande) {
		return demandeRepository.save(demande);
	}

	@Override
	public List<Demande> getAllDemandes() {
		return demandeRepository.findAll();
	}

}
