package org.sid.metier;

import java.util.List;
import java.util.Optional;

import org.sid.dao.BookRepository;
import org.sid.dao.CategoryRepository;
import org.sid.dao.DemandeRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Category;
import org.sid.entities.Demande;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BiblioServicesImpl implements BiblioServices{

	@Autowired
	public CategoryRepository categoryRepository;
	
	@Autowired
	public BookRepository bookRepository;
	
	@Autowired
	public DemandeRepository demandeRepository;
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findCategoryById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.get();
	}

	@Override
	public void deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);
	}
	
	@Override
	public Category updateCategoryById(Long id, Category category) {
		Category C = categoryRepository.findById(id).get();
		C.setId_category(id);
		return categoryRepository.save(C);
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Demande saveDemande(Demande demande) {
		return demandeRepository.save(demande);
	}

	@Override
	public List<Demande> findAllDemandes() {
		return demandeRepository.findAll();
	}

	@Override
	public User findUserByMailAndPassword(String mail, String password) {
		return userRepository.listloginUser(mail, password);
	}

	@Override
	public Page getCategories(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}


}
