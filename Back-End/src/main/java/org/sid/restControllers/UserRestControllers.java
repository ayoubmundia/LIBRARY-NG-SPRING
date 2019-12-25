package org.sid.restControllers;


import java.util.List;

import org.sid.entities.Demande;
import org.sid.entities.User;
import org.sid.metier.BiblioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserRestControllers.BASE_URL)
public class UserRestControllers {
	
	public static final String BASE_URL = "api/users";
	
	@Autowired
	public BiblioServices biblioServices;
	
	public UserRestControllers(BiblioServices bs) {
		this.biblioServices = bs;
	}
	
	@GetMapping(value="/demande")
	List<Demande> getAllDemandes(){
		return biblioServices.findAllDemandes();
	}
	
	@PostMapping(value="/demande")
	@ResponseStatus(HttpStatus.CREATED)
	public Demande saveDemande(@RequestBody Demande demande) {
		return biblioServices.saveDemande(demande);
	}
	
	@GetMapping("/mail={mail}&password={password}")
	public User getUserBymailAndPass(@PathVariable String mail,@PathVariable String password) {
		return biblioServices.findUserByMailAndPassword(mail, password);
	}
}
