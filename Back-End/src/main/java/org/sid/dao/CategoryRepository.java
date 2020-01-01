package org.sid.dao;

import org.sid.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	public Page<Category> findAll(Pageable pageable);
}
