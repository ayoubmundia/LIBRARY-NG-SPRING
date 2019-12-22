package org.sid.metier;

import java.util.List;
import java.util.Optional;

import org.sid.dao.CategoryRepository;
import org.sid.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiblioServicesImpl implements BiblioServices{

	@Autowired
	public CategoryRepository categoryRepository;
	

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

}
