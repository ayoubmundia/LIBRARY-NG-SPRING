package org.sid.metier;

import java.util.List;

import org.sid.entites.Category;
import org.sid.entites.Demande;
import org.sid.entites.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.sid.entites.Book;

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
