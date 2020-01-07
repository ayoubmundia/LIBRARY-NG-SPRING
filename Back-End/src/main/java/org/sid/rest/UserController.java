package org.sid.rest;

import java.util.List;

import org.sid.entities.User;
import org.sid.metier.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
public static final String BASE_URL = "api/users";
	
	@Autowired
	public IServices biblioServices;
	
	public UserController(IServices bs) {
		this.biblioServices = bs;
	}
	
	@GetMapping()
	List<User> getAllUsers(){
		return biblioServices.getAllUsers();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/singin")
	@ResponseBody
	public User getUserBymailAndPass(@RequestParam String mail,@RequestParam String password) {
		return biblioServices.findUserByMailAndPassword(mail, password);
	}
}
