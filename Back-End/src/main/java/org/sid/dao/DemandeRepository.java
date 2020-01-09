package org.sid.dao;

import org.sid.entities.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface DemandeRepository extends JpaRepository<Demande, Long> {

}
