package com.pws.employee.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pws.employee.entity.User;

import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

	@Query("db.Usero .find({\n" +
			" \"$where\": \"this.o.email  == this. :email\"\n" +
			"},{\n" +
			"   \"o\": 1\n" +
			"}\n" +
			");")
	Optional<User> findUserByEmail(String email);
}
