package org.sid.metier;

import java.util.List;

import org.sid.entities.Book;
import org.sid.entities.Category;
import org.sid.entities.Demande;
import org.sid.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServices {
	//Category Serivces
	List<Category> getAllCategories();
	Category getCategoryById(Long id);
	void deleteCategoryById(Long id);
	Category updateCategoryById(Long id,Category category);
	Category addCategory(Category category);
	List<Book> getBookOfCategory(Long id);
	Page<Book> getBookOfCategoryPage(Long id, Pageable page);
	Page getAllCategoriesPage(Pageable pageable );
	//User Services
	User findUserByMailAndPassword(String mail, String password);
	List<User> getAllUsers();
	//Demande Services
	Demande addDemande(Demande demande);
	List<Demande> getAllDemandes();
}
