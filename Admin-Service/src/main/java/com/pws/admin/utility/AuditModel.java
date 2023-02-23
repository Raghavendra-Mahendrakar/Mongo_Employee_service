package com.pws.admin.utility;

import java.io.Serializable;
import java.util.Date;



import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditModel implements Serializable {

    private static final long serialVersionUID = 1L;


    @CreatedDate
    @JsonIgnore
    public Date createdAt;


    @JsonIgnore
    @CreatedBy
    public String createdBy;


    @JsonIgnore
    @LastModifiedDate
    public Date updatedAt;

    @JsonIgnore
    @LastModifiedBy
    public String updatedBy;




}

