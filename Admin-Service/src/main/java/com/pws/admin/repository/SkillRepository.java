package com.pws.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pws.admin.entity.Skill;


@Repository

public interface SkillRepository extends MongoRepository<Skill, Integer> {

}
