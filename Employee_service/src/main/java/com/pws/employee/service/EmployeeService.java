package com.pws.employee.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pws.employee.dto.SignUpDTO;
import com.pws.employee.dto.UpdatePasswordDTO;
import com.pws.employee.dto.UserBasicDetailsDTO;
import com.pws.employee.dto.UserSkillXrefDTO;
import com.pws.employee.entity.Skill;
import com.pws.employee.entity.User;
import com.pws.employee.entity.UserSkillXref;
import com.pws.employee.exception.config.PWSException;

public interface EmployeeService {

	void employeeSignUp(SignUpDTO signupDTO) throws PWSException;

	List<Skill> fetchAllSkill() throws PWSException;

//	void updateUserPassword(UpdatePasswordDTO userPasswordDTO) throws PWSException;

//	UserBasicDetailsDTO getUserBasicInfoAfterLoginSuccess(String email) throws PWSException;

//	List<Skill> fetchAllSkillsByFlag(Integer id, Boolean flag) throws PWSException;

	void deactivateOrActivateSkillById(Integer id, Boolean flag) throws PWSException;

	void addSkillToUser(UserSkillXrefDTO userSkillXrefDTO) throws PWSException;

//	public Page<Skill> fetchAllUserSkills(int page, int pageSize, String sort, String order, Integer id)
//			throws PWSException;
}
