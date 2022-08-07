package com.javabydeveloper.demo.embedded;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

import com.javabydeveloper.model.ContactAddress;
import com.javabydeveloper.util.UserType;

import lombok.Data;

@Table("USER_DETAILS")
@Data
public class User {

	@Id
    private Long id;
    
    private String userName;
    private String password;
    private Date createdTime;
    private Date updatedTime;
    
    @Embedded.Nullable
    private ContactAddress address;
    
    private UserType userType;
}
