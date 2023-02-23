package com.pws.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pws.employee.entity.Permission;

@Repository
public interface PermissionRepository extends MongoRepository<Permission, Integer> {

//	@Query("db.Permissiono .find({\n" +
//			" \"$where\": \"this.o.role.id == this. :roleId\"\n" +
//			"},{\n" +
//			"   \"o\": 1\n" +
//			"}\n" +
//			");")
//	List<Permission> getAllUserPermisonsByRoleId(Integer roleId);
}
