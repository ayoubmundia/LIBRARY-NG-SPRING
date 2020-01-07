package org.sid.rest;

import java.util.List;
import org.sid.dao.OperationRepository;
import org.sid.entities.Emprunt;
import org.sid.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(OperationRestController.BASE_URL)
@Transactional
public class OperationRestController {
	
	@Autowired
	private OperationRepository operatioRepository;
	
	public static final String BASE_URL = "api/operations";
	
	
	/*Consulter tout les operations */
	@RequestMapping(method=RequestMethod.GET) 
	public List<Operation> listOperations(){
		return operatioRepository.findAll();
	}
	
	/* rechercher un operation*/
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Operation getOperation(@PathVariable("id") Long id ){
		return operatioRepository.findById(id).get();
	}
	
	/* ajouter operation=emprunter */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST)
	public Operation saveEmprunt(@RequestBody Emprunt emprunt){ 
		return operatioRepository.save(emprunt);
	}
	
	/* modifier operation=prolonger */
	//@CrossOrigin(origins = "http://localhost:4200")
	//@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	//public Operation updateOperation(@RequestBody Prolongation prolonger, @PathVariable Long id,  Date date_debut,  Date date_fin){ /* @PathVariable pour recuperer id */
		/*Emprunt e=new Emprunt();
		e.setId_operation(id);
		e.setDate_debut_operation(date_debut);
		e.setDate_debut_operation(date_fin);
		return operatioRepository.saveAndFlush(prolonger);
	}*/
	
	/* supprimer operation */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteOperation(@RequestBody Operation operation, @PathVariable("id") Long id){ 
		operatioRepository.deleteById(id);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/operationPages", method = RequestMethod.GET)
	Page<Operation> operationsPageable(Pageable pageable) {
		return operatioRepository.findAll(pageable);

	}

}
