package com.pws.admin.entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;


import com.pws.admin.utility.AuditModel;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "UserRoleXref")
public class UserRoleXref extends AuditModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@DBRef
	private User user;

	@DBRef
	private	Role role;
	
	@Column(name="is_active",nullable=false)
	@ColumnDefault("TRUE")
	private Boolean isActive;

	
	

}
