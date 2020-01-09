package org.sid.rest;

import java.util.List;

import org.sid.entities.Demande;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(DemandeController.BASE_URL)
public class DemandeController {
public static final String BASE_URL = "api/demandes";
	
	@Autowired
	public IServices biblioServices;
	
	public DemandeController(IServices bs) {
		this.biblioServices = bs;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping()
	List<Demande> getAllDemandes(){
		return biblioServices.getAllDemandes();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Demande saveDemande(@RequestBody Demande demande) {
		return biblioServices.addDemande(demande);
	}
	
	@GetMapping("/{id}")
	public Demande getDemandeById(@PathVariable Long id) {
		return biblioServices.getDemandeById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/listPageable", method = RequestMethod.GET)
	Page<Demande> demandesPageable(Pageable pageable) {
		return biblioServices.getAllDemandesPage(pageable);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDemande(@PathVariable Long id) {
		biblioServices.deleteDemandeById(id);
	}
}
