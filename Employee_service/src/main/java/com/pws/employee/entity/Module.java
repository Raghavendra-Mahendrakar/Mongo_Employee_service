package com.pws.employee.entity;

import java.io.Serializable;

import org.hibernate.annotations.ColumnDefault;

import com.pws.employee.utility.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "module")
public class Module extends AuditModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Field(value = "id")
	private int id;

	@Field(value = "is_active")
	private Boolean isActive;

	@Field(value = "name")
	@NotBlank
	private String name;

}
