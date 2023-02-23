package com.pws.employee.entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import com.pws.employee.utility.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_role_xref")
public class UserRoleXref extends AuditModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Field(name = "id")
	private int id;


	@DBRef
	@Field(name = "user_id")
	private List<User> user;

	@DBRef
	@Field(name = "role_id")
	private List<Role> role;

	@Field(name = "is_active")
	@NotBlank
	private Boolean isActive=true;

}
