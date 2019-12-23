package org.sid.dao;

import org.sid.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
public interface BookRepository extends JpaRepository<Book, Long> {
	public Page<Book> findAll(Pageable pageable);

}
