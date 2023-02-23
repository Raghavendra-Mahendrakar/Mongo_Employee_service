package com.pws.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_skill_xref")
public class UserSkillXref {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Field(name = "id")
	private Integer id;

	@DBRef
	@Field(name = "user_id")
	private List<User> user;

	@DBRef
	@Field(name = "skill_id")
	private List<Skill> skill;

	@Enumerated(EnumType.STRING)
	@Field(name = "proficiency_level")
	@NotBlank
	private Keyword proficiencyLevel;

	public enum Keyword {
		Beginner, Intermediate, Expert
	}

	@Field(name = "is_active")
	@NotBlank
	private Boolean isActive;

}
