package org.sid.restControllers;

import java.util.List;

import org.sid.entities.Book;
import org.sid.entities.Category;
import org.sid.metier.BiblioServices;
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

@RestController
@RequestMapping(CategoryRestController.BASE_URL)
public class CategoryRestController {
	
	public static final String BASE_URL = "api/categories";
	
	@Autowired
	public BiblioServices biblioServices;
	
	public CategoryRestController(BiblioServices bs) {
		this.biblioServices = bs;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	List<Category> getAllCategories(){
		return biblioServices.findAllCategories();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}/livres")
	List<Book> getBookByCategory(@PathVariable Long id){
		return biblioServices.getBooksByCat(id);
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable Long id) {
		return biblioServices.findCategoryById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteCategoryById(@PathVariable Long id) {
		biblioServices.deleteCategoryById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Category saveCategory(@RequestBody Category category) {
		return biblioServices.saveCategory(category);
	}

	@PutMapping("/{id}")
	public Category updateCategoryById(@PathVariable Long id,@RequestBody Category cst){
		cst.setId_category(id);
		return biblioServices.saveCategory(cst);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/listPageable", method = RequestMethod.GET)
	Page<Category> booksPageable(Pageable pageable) {
		return biblioServices.getCategories(pageable);

	}
	
}
