package org.sid.dao;

import org.sid.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface OperationRepository extends JpaRepository<Operation, Long>{

}
