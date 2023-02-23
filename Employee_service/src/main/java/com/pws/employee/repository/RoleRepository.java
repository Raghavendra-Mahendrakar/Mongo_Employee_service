package com.pws.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pws.employee.entity.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, Integer> {

//	@Query("db.Roleo .find({\n" +
//			" \"$where\": \"this.o.name  == this. :rolename\"\n" +
//			"},{\n" +
//			"   \"o\": 1\n" +
//			"}\n" +
//			");")
//	Optional<Role> findByRolename(String rolename);

}
