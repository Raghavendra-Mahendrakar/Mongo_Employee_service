package com.pws.admin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pws.admin.entity.Permission;
@Repository

public interface PermissionRepository extends MongoRepository<Permission, Integer> {

	void save(Optional<Permission> optionalPermission);

	 @Query("db.Permission.find({ \"role.id\": roleId });\n")
    List<Permission> getAllUserPermisonsByRoleId(Integer roleId);

	
}
