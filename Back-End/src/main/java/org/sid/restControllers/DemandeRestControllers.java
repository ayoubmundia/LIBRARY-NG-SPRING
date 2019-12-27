package org.sid.restControllers;

import java.util.List;

import org.sid.entities.Demande;
import org.sid.metier.BiblioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DemandeRestControllers.BASE_URL)
public class DemandeRestControllers {
	
	public static final String BASE_URL = "api/demandes";
	
	@Autowired
	public BiblioServices biblioServices;
	
	public DemandeRestControllers(BiblioServices bs) {
		this.biblioServices = bs;
	}
	
	@GetMapping()
	List<Demande> getAllDemandes(){
		return biblioServices.findAllDemandes();
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Demande saveDemande(@RequestBody Demande demande) {
		return biblioServices.saveDemande(demande);
	}
}
