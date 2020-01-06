package org.sid.dao;

import org.sid.entites.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

}
