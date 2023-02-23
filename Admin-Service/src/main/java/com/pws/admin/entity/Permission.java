package com.pws.admin.entity;

import java.io.Serializable;
import java.util.List;


import com.pws.admin.utility.AuditModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Permission")
public class Permission extends AuditModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id

    private int id;


    private Boolean isActive;


    private Boolean isView;


    private Boolean isAdd;

    private Boolean isUpdate;


    private Boolean isDelete;

//    @DocumentReference
//    @Field(name = "module_id")
//    private List<Module> module;
//
//    @DocumentReference
//    @Field(name = "role_id")
//    private Role role;

    @DBRef
    private Module module;


    @DBRef
    private Role role;



}
