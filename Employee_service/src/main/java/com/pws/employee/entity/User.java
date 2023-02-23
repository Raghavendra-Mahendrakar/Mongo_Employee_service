package com.pws.employee.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pws.employee.utility.AuditModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User extends AuditModel implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";

	@Id
	@Indexed(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Field(name = "firstname")
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private Date dateOfBirth;

	@Indexed(unique = true)
	private String email;

	@NotBlank
	@Size(max = 10)
	private String phoneNumber;

	@NotBlank
	private String password;

	@NotBlank
	private Boolean isActive=true;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isActive;
	}
}
