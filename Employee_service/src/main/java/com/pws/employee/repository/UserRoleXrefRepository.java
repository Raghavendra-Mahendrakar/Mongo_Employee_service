package com.pws.employee.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pws.employee.entity.Role;
import com.pws.employee.entity.User;
import com.pws.employee.entity.UserRoleXref;

import java.util.List;

@Repository
public interface UserRoleXrefRepository extends MongoRepository<UserRoleXref, Integer> {
//
//	@Query("db.UserRoleXrefo .find({\n" +
//			" \"$where\": \"this.o.role.id == this. :roleId\"\n" +
//			"},{\n" +
//			"   \"o.user\": 1\n" +
//			"}\n" +
//			");")
//	List<User> fetchAllUsersByRoleId(Integer roleId);
//
//
//	@Query("db.UserRoleXrefo .find({\n" +
//			"\n" +
//			"   \"$and\": [{\n" +
//			"   \"$where\": \"this.o.user.id == this. :id \"\n" +
//			" },{ \"$where\": \"this. o.role.IsActive == this.TRUE\"\n" +
//			"   }]\n" +
//			"},{\n" +
//			"   \"o.role\": 1\n" +
//			"}\n" +
//			");")
//	List<Role> findAllUserRoleByUserId(Integer id);
}
