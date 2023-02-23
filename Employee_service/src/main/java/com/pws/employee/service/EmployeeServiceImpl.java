package com.pws.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pws.employee.dto.SignUpDTO;
import com.pws.employee.dto.UpdatePasswordDTO;
import com.pws.employee.dto.UserBasicDetailsDTO;
import com.pws.employee.dto.UserSkillXrefDTO;
import com.pws.employee.entity.Permission;
import com.pws.employee.entity.Role;
import com.pws.employee.entity.Skill;
import com.pws.employee.entity.User;
import com.pws.employee.entity.UserRoleXref;
import com.pws.employee.entity.UserSkillXref;
import com.pws.employee.exception.config.PWSException;
import com.pws.employee.repository.PermissionRepository;
import com.pws.employee.repository.RoleRepository;
import com.pws.employee.repository.SkillRepository;
import com.pws.employee.repository.UserRepository;
import com.pws.employee.repository.UserRoleXrefRepository;
import com.pws.employee.repository.UserSkillXrefRepository;
import com.pws.employee.utility.CommonUtils;
import com.pws.employee.utility.DateUtils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static com.pws.employee.entity.User.SEQUENCE_NAME;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private UserSkillXrefRepository userSkillXrefRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRoleXrefRepository userRoleXrefRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private SequenceGeneratorService service;
	@Override
	public void employeeSignUp(SignUpDTO signupDTO) throws PWSException {
		Optional<User> optionalUser = userRepository.findUserByEmail(signupDTO.getEmail());
		if (optionalUser.isPresent())
			throw new PWSException("User Already Exist with Email : " + signupDTO.getEmail());
//		Optional<User> optionalUse = userRepository.findById(signupDTO.getId());
//		if (optionalUse.isPresent())
//			throw new PWSException("User id Exist with Email : " + signupDTO.getId() +"  "+ signupDTO.getEmail());
		User user = new User();
		user.setId(service.getSequenceNumber(SEQUENCE_NAME));
//		user.setId(signupDTO.getId());
		user.setDateOfBirth(DateUtils.getUtilDateFromString(signupDTO.getDateOfBirth()));
		user.setFirstName(signupDTO.getFirstName());
		user.setIsActive(true);
		user.setLastName(signupDTO.getLastName());
		user.setEmail(signupDTO.getEmail());
		user.setPhoneNumber(signupDTO.getPhoneNumber());
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		// Set new password
		user.setPassword(encoder.encode(signupDTO.getPassword()));
		userRepository.save(user);

//		Optional<Role> optionalRole = roleRepository.findByRolename(signupDTO.getRoleName());
//		Role role = optionalRole.get();
//		UserRoleXref userRoleXref = new UserRoleXref();
//		userRoleXref.setRole((List<Role>) role);
//		userRoleXref.setUser((List<User>) user);
//		userRoleXref.setIsActive(true);
//		userRoleXrefRepository.save(userRoleXref);

	}

	@Override
	public List<Skill> fetchAllSkill() throws PWSException {
		return skillRepository.findAll();
	}

//	@Override
//	public void updateUserPassword(UpdatePasswordDTO userPasswordDTO) throws PWSException {
//		Optional<User> optionalUser = userRepository.findUserByEmail(userPasswordDTO.getUserEmail());
//
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		User user = null;
//		if (!optionalUser.isPresent()) {
//			throw new PWSException("User Not present ");
//		}
//		user = optionalUser.get();
//		if (encoder.matches(userPasswordDTO.getOldPassword(), user.getPassword())) {
//			if (userPasswordDTO.getNewPassword().equals(userPasswordDTO.getConfirmNewPassword())) {
//
//				user.setPassword(encoder.encode(userPasswordDTO.getConfirmNewPassword()));
//				userRepository.save(user);
//			} else {
//				throw new PWSException("new password and confirm password doesnot match ");
//			}
//
//		} else {
//			throw new PWSException("oldpassword not matched");
//		}
//
//	}

//	@Override
//	public UserBasicDetailsDTO getUserBasicInfoAfterLoginSuccess(String email) throws PWSException {
//		Optional<User> optionalUser = userRepository.findUserByEmail(email);
//		if (!optionalUser.isPresent())
//			throw new PWSException("User not Exist with Email : " + email);
//
//		User user = optionalUser.get();
//		UserBasicDetailsDTO userBasicDetailsDTO = new UserBasicDetailsDTO();
//		userBasicDetailsDTO.setUser(user);
//
//		List<Role> roleList = userRoleXrefRepository.findAllUserRoleByUserId(user.getId());
//		userBasicDetailsDTO.setRoleList(roleList);
//		List<Permission> permissionList = null;
//		if (roleList.size() > 0)
//			permissionList = permissionRepository.getAllUserPermisonsByRoleId(roleList.get(0).getId());
//
//		userBasicDetailsDTO.setPermissionList(permissionList);
//		List<Skill> skilllist = userSkillXrefRepository.fetchuserSkillsByid(user.getId());
//		userBasicDetailsDTO.setSkillList(skilllist);
//
//		return userBasicDetailsDTO;
//	}

	@Override
	public void deactivateOrActivateSkillById(Integer id, Boolean flag) throws PWSException {
		Optional<UserSkillXref> optionalSkill = userSkillXrefRepository.findById(id);
		if (optionalSkill.isPresent()) {
			optionalSkill.get().setIsActive(flag);
			userSkillXrefRepository.save(optionalSkill.get());
		}

	}

	@Override
	public void addSkillToUser(UserSkillXrefDTO userSkillXrefDTO) throws PWSException {
		UserSkillXref userSkillXref = new UserSkillXref();
		Optional<User> optionalUser = userRepository.findById(userSkillXrefDTO.getUserId());
		if (optionalUser.isPresent()) {
//			userSkillXref.setUser(optionalUser.get());
		} else {
			throw new PWSException("User Doest Exist");
		}
		Optional<Skill> optionalskill = skillRepository.findById(userSkillXrefDTO.getSkillId());
		if (optionalskill.isPresent()) {
//			userSkillXref.setSkill(optionalskill.get());
		} else {
			throw new PWSException("skill Doest Exist");
		}

		userSkillXref.setProficiencyLevel(userSkillXrefDTO.getProficiencyLevel());
		userSkillXref.setIsActive(userSkillXrefDTO.getIsActive());
		userSkillXrefRepository.save(userSkillXref);
	}

//	@Override
//	public List<Skill> fetchAllSkillsByFlag(Integer id, Boolean flag) throws PWSException {
//		return userSkillXrefRepository.fetchAllSkillsByFlag(id, flag);
//	}

//	@Override
//	public Page<Skill> fetchAllUserSkills(int page, int pageSize, String sort, String order, Integer id)
//			throws PWSException {
//		Pageable pageable = CommonUtils.getPageable(page, pageSize, sort, order);
//		return userSkillXrefRepository.fetchAllUserSkills(pageable, id);
//	}

}
