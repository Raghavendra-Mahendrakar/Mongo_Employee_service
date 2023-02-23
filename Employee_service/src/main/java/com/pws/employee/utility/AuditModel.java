package com.pws.employee.utility;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Field;

@MappedSuperclass

public abstract class AuditModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Field(name = "created_at")
	@NotBlank
	@CreatedDate
	@JsonIgnore
	public Date createdAt;

	@Field(name = "created_by")
	@NotBlank
	@JsonIgnore
	@CreatedBy
	public String createdBy;

	@Field(name = "updated_at")
	@NotBlank
	@JsonIgnore
	@LastModifiedDate
	public Date updatedAt;

	@Field(name = "updated_by")
	@NotBlank
	@JsonIgnore
	@LastModifiedBy
	public String updatedBy;

}
