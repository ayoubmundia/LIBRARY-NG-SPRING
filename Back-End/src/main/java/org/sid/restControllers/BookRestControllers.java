package org.sid.restControllers;

import java.util.List;

import org.sid.dao.BookRepository;
import org.sid.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BookRestControllers.BASE_URL)
public class BookRestControllers {
	
	public static final String BASE_URL = "api/livres";
	
	/*Injection de dépendances*/
	@Autowired 
	private BookRepository bookRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/listPageable", method = RequestMethod.GET)
	Page<Book> booksPageable(Pageable pageable) {
		return bookRepository.findAll(pageable);

	}
	
	/*Consulter tout les livres en convertissant les résultats en format json*/
	@RequestMapping(method=RequestMethod.GET) 
	public List<Book> listLivre(){
		return bookRepository.findAll();
	}
	
	/* rechercher un livre*/
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Book getLivre(@PathVariable("id") Long id ){
		return bookRepository.findById(id).get();
	}
	
	/* rechercher un livre*/
	/*@RequestMapping(value="/livres/{titre}", method=RequestMethod.GET)
	public Livre getLivre(@PathVariable("titre") String titre ){
		return livreRepository.findAllByTitre(titre);
	}*/
	
	/* ajouter livre */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST)
	public Book save(@RequestBody Book book){ 
		return bookRepository.save(book);
	}
	
	/* modifier livre */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Book update(@RequestBody Book book, @PathVariable Long id){ /* @PathVariable pour recuperer id */
		book.setId_book(id);
		return bookRepository.saveAndFlush(book);
	}
	
	/* supprimer livre */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@RequestBody Book book, @PathVariable("id") Long id){ /* @PathVariable pour recuperer id */
		bookRepository.deleteById(id);
	}
}
