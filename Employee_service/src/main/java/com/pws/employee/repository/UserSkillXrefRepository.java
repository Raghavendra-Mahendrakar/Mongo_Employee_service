package com.pws.employee.repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.pws.employee.entity.Skill;
import com.pws.employee.entity.UserSkillXref;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserSkillXrefRepository extends MongoRepository<UserSkillXref, Integer> {

//	@Query("db.UserSkillXrefo .find({\n" +
//			" \"$where\": \"this.o.user.id == this.:id\"\n" +
//			"},{\n" +
//			"   \"o.skill\": 1\n" +
//			"}\n" +
//			");")
//	List<Skill> fetchuserSkillsByid(int id);


//	@Query("db.UserSkillXrefo .find({\n" +
//			"\n" +
//			"   \"$and\": [{\n" +
//			"   \"$where\": \"this.o.user.id == this.:id \"\n" +
//			" },{ \"$where\": \"this. o.isActive == this.:flag\"\n" +
//			"   }]\n" +
//			"},{\n" +
//			"   \"o.skill\": 1\n" +
//			"}\n" +
//			");")
//	List<Skill> fetchAllSkillsByFlag(Integer id, Boolean flag);
//
//	@Query("db.UserSkillXrefo .find({\n" +
//			" \"$where\": \"this.o.user.id == this.:id\"\n" +
//			"},{\n" +
//			"   \"o.skill\": 1\n" +
//			"}\n" +
//			");")
//    Page<Skill> fetchAllUserSkills(Pageable pageable,Integer id);
}
