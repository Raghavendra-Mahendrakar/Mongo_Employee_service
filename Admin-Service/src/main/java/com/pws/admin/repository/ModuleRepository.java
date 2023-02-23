package com.pws.admin.repository;

import com.pws.admin.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Vinayak M
 * @Date 10/01/23
 */
@Repository
public interface ModuleRepository extends MongoRepository<Module, Integer> {
}
