package org.sid.metier;

import java.util.List;
import org.sid.entities.Category;
import org.sid.entities.Demande;

public interface BiblioServices {
	List<Category> findAllCategories();
	List<Demande> findAllDemandes();
	Category findCategoryById(Long id);
	void deleteCategoryById(Long id);
	Category updateCategoryById(Long id,Category category);
	Category saveCategory(Category category);
	Demande saveDemande(Demande demande);
}
