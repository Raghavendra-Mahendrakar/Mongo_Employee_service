package com.pws.employee.contoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pws.employee.ApiSuccess;
import com.pws.employee.dto.LoginDTO;
import com.pws.employee.dto.SignUpDTO;
import com.pws.employee.dto.UpdatePasswordDTO;
import com.pws.employee.dto.UserBasicDetailsDTO;
import com.pws.employee.dto.UserSkillXrefDTO;
import com.pws.employee.entity.Skill;
import com.pws.employee.entity.User;
import com.pws.employee.entity.UserSkillXref;
import com.pws.employee.exception.config.PWSException;
import com.pws.employee.service.EmployeeService;
import com.pws.employee.utility.CommonUtils;
import com.pws.employee.utility.JwtUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
public class EmployeeController {

	Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@ApiOperation(value = "Authentication of Employee")
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody LoginDTO loginDTO) throws Exception {
		log.info("authenticate is called");
		try {

			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUserName(), loginDTO.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(loginDTO.getUserName());
	}

	@ApiOperation(value = "Employee Signup")
	@PostMapping("public/Employee/signup")
	public ResponseEntity<Object> signup(@RequestBody SignUpDTO signUpDTO) throws PWSException {
		log.info("signup called");
		employeeService.employeeSignUp(signUpDTO);
		return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.CREATED));
	}

	@ApiOperation(value = "Fetch All skills")
	@GetMapping("private/fetch/all/skill")
	public ResponseEntity<Object> fetchAllSkill() throws PWSException {
		log.info("fetchAllRole is called");
		List<Skill> skillList = employeeService.fetchAllSkill();
		return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK, skillList));
	}

//	@ApiOperation(value="Update Existing User Password")
//	@PutMapping("private/update/user/password")
//	public ResponseEntity<Object> updateUserPassword(@RequestBody UpdatePasswordDTO userPasswordDTO)
//			throws PWSException {
//		employeeService.updateUserPassword(userPasswordDTO);
//		return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK));
//	}

//	@ApiOperation(value="Get User Basic Info After Success Login")
//	@GetMapping("private/userdetails")
//	public ResponseEntity<Object> getUserBasicInfoAfterLoginSuccess(@RequestParam String email) throws PWSException {
//		UserBasicDetailsDTO userBasicDetailsDTO = employeeService.getUserBasicInfoAfterLoginSuccess(email);
//		return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK, userBasicDetailsDTO));
//	}

	@ApiOperation(value = "Activate or Deactivate SkillById")
	@PostMapping("private/skill/activate/deactivate")
	public ResponseEntity<Object> deactivateOrActivateSkillById(@RequestParam Integer id, @RequestParam Boolean flag)
			throws PWSException {
		log.info("deactivateOrActivateSkillById is called");
		employeeService.deactivateOrActivateSkillById(id, flag);
		return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK));
	}

	@ApiOperation(value = "To Add Skill To User")
	@PostMapping("private/add/skill/to/user")
	public ResponseEntity<Object> addSkillToUser(@RequestBody UserSkillXrefDTO userSkillXrefDTO) throws PWSException {
		employeeService.addSkillToUser(userSkillXrefDTO);
		return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK));
	}

//	@ApiOperation(value="Fetch All skill from UserSkillXref Table ")
//	@GetMapping("private/fetch/all/userSkillXref/active")
//	public ResponseEntity<Object> fetchAllSkillsByFlag(@RequestParam Integer id, @RequestParam Boolean flag)
//			throws PWSException {
//		List<Skill> listOfActiveUserSkillXref = employeeService.fetchAllSkillsByFlag(id, flag);
//		return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK, listOfActiveUserSkillXref));
//	}

//	@ApiOperation(value="Pagination")
//	@GetMapping("private/user/fetchall/skill")
//	public ResponseEntity<Object> fetchAllUserSkills(
//			@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
//			@RequestParam(value = "size", required = false, defaultValue = Integer.MAX_VALUE + "") Integer size,
//			@RequestParam(value = "sort", required = false, defaultValue = "Id") String sort,
//			@RequestParam(value = "order", required = false, defaultValue = "DESCENDING") String order,
//			@RequestParam Integer id) throws PWSException {
//		Page<Skill> skilllist = employeeService.fetchAllUserSkills(page, size, sort, order, id);
//		return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK, skilllist));
//	}
}
