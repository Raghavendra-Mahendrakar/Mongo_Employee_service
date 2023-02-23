package com.pws.employee.repository;


import com.pws.employee.entity.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SkillRepository extends MongoRepository<Skill, Integer> {

}
