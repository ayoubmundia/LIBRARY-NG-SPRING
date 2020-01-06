package org.sid.dao;

import org.sid.entites.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DemandeRepository extends JpaRepository<Demande, Long> {

}
