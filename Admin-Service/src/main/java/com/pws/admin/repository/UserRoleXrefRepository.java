package com.pws.admin.repository;

import com.pws.admin.entity.Role;
import com.pws.admin.entity.User;
import com.pws.admin.entity.UserRoleXref;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author Vinayak M
 * @Date 10/01/23
 */

@Repository
public interface UserRoleXrefRepository extends MongoRepository<UserRoleXref, Integer> {

    @Query("db.UserRoleXref.find({ \"role.id\": roleId }, { \"user\": 1 });")
    List<User> fetchAllUsersByRoleId(Integer roleId);


    @Query("db.UserRoleXref.find({ \"user.id\": id, \"role.IsActive\": true }, { \"role\": 1 });\n")
    List<Role> findAllUserRoleByUserId(Integer id);
    
}
