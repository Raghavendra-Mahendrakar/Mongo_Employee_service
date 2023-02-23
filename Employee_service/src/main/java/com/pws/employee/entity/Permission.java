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
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "permissions")
public class Permission extends AuditModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Field(name = "id")
	private int id;

	@Field(name = "is_active")
	@NotBlank
	private Boolean isActive=true;

	@Field(name = "is_view")
	@NotBlank
	private Boolean isView=true;

	@Field(name = "is_add")
	@NotBlank
	private Boolean isAdd=true;

	@Field(name = "is_update")
	@NotBlank
	private Boolean isUpdate=true;

	@Field(name = "is_delete")
	private Boolean isDelete=true;

	@DBRef
	@Field(name = "model_id")
	private List<Module> model;

	@DBRef
	@Field(name = "role_id")
	private List<Role> role;

}
