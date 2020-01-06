package org.sid.rest;

import java.util.List;

import org.sid.entites.Book;
import org.sid.entites.Category;
import org.sid.metier.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {
	
	public static final String BASE_URL = "api/categories";
	
	@Autowired
	public IServices biblioServices;
	
	public CategoryController(IServices bs) {
		this.biblioServices = bs;
	}
	
	@GetMapping
	List<Category> getAllCategories(){
		return biblioServices.getAllCategories();
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable Long id) {
		return biblioServices.getCategoryById(id);
	}
	
	@GetMapping("/{id}/livres")
	List<Book> getBooksByCategory(@PathVariable Long id){
		return biblioServices.getBookOfCategory(id);
	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		biblioServices.deleteCategoryById(id);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Category addCategory(@RequestBody Category category) {
		return biblioServices.addCategory(category);
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Long id,@RequestBody Category cst){
		cst.setId_category(id);
		return biblioServices.updateCategoryById(id, cst);
	}

	@RequestMapping(value = "/listPageable", method = RequestMethod.GET)
	Page<Category> getAllCategoriesPage(Pageable pageable) {
		return biblioServices.getAllCategoriesPage(pageable);
	}
	
	@RequestMapping(value = "/{id}/books", method = RequestMethod.GET)
	Page<Book> getAllCategoriesPage(@PathVariable Long id, Pageable pageable ) {
		return biblioServices.getBookOfCategoryPage(id,pageable);
	}

}
