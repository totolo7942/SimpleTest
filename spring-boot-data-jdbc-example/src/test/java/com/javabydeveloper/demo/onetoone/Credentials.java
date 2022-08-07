package com.javabydeveloper.demo.onetoone;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("USER_CREDENTIALS")
@Data // lombok
@AllArgsConstructor @NoArgsConstructor
public class Credentials {

	@Id
	private Long id;
	private String userName;
	private String password;
	
}
