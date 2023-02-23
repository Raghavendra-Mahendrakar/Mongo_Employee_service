package com.pws.employee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pws.employee.entity.Module;

@Repository
public interface ModuleRepository extends MongoRepository<Module, Integer> {
}
