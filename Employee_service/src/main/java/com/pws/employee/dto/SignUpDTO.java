package com.pws.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {


//	private int id;

	private String firstName;

	private String lastName;

	private String dateOfBirth;

	private String email;

	private String phoneNumber;

	private String password;

	private String roleName;
}
