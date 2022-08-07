package com.javabydeveloper.demo.onetoone;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import com.javabydeveloper.util.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("USER_DETAILS")
public class User {

	@Id
	private Long id;
	private Date createdTime;
	private Date updatedTime;
	@Column("DOB")
	private Date dateofBirth;
	private UserType userType;

	@Column("USER_DETAIL")
	private Credentials credentials;

}
