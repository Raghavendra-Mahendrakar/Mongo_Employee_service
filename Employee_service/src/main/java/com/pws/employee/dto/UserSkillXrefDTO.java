package com.pws.employee.dto;

import com.pws.employee.entity.UserSkillXref.Keyword;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSkillXrefDTO {

	private Integer id;

	private Integer userId;

	private Integer skillId;

	private Keyword proficiencyLevel;

	private Boolean isActive;

}
