package org.sid.restControllers;


import java.util.List;

import org.sid.entities.User;
import org.sid.metier.BiblioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(UserRestControllers.BASE_URL)
public class UserRestControllers {
	
	public static final String BASE_URL = "api/users";
	
	@Autowired
	public BiblioServices biblioServices;
	
	public UserRestControllers(BiblioServices bs) {
		this.biblioServices = bs;
	}
	
	@GetMapping()
	List<User> getAllUsers(){
		return biblioServices.findAllUsers();
	}
	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping("/mail={mail}&password={password}")
	@GetMapping("/singin")
	@ResponseBody
//	public User getUserBymailAndPass(@PathVariable String mail,@PathVariable String password) {
	public User getUserBymailAndPass(@RequestParam String mail,@RequestParam String password) {
		return biblioServices.findUserByMailAndPassword(mail, password);
	}
}
