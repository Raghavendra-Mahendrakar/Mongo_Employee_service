package com.pws.admin.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import com.pws.admin.utility.AuditModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrePersist;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User extends AuditModel implements UserDetails, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";


    @Id
    @Indexed
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Field(name = "firstname")
    private String firstName;

    @Field(name = "lastName")
    private String lastName;

    @Field(name = "DOB")
    private Date dateOfBirth;

    @Field(name = "email")
    private String email;

    @Field(name = "phn_number")
    private String phoneNumber;

    @Field(value = "password")
    private String password;


    @Field(value = "is_Active")
    private Boolean isActive = true;


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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;

    }

}


