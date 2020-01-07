package org.sid.dao;

<<<<<<< HEAD:Back-End/src/main/java/org/sid/dao/EmpruntRepository.java
import org.sid.entites.Emprunt;
=======
import org.sid.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
>>>>>>> 10c3bd9f203a51f8fc313e6d9630f9fd4e9eee43:Back-End/src/main/java/org/sid/dao/OperationRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
<<<<<<< HEAD:Back-End/src/main/java/org/sid/dao/EmpruntRepository.java
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

=======
public interface OperationRepository extends JpaRepository<Operation, Long>{
	public Page<Operation> findAll(Pageable pageable);
>>>>>>> 10c3bd9f203a51f8fc313e6d9630f9fd4e9eee43:Back-End/src/main/java/org/sid/dao/OperationRepository.java
}
