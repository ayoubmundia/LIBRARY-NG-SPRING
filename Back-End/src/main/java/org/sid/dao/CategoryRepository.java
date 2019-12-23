package org.sid.dao;

import org.sid.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
