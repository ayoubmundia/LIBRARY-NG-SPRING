package org.sid.dao;

import org.sid.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select o from User o where o.mail=:x and o.password=:y")
	public User  listloginUser(@Param("x")String mail, @Param("y") String password); 
}
