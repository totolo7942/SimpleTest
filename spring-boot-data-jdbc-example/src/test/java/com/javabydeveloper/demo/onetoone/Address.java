package com.javabydeveloper.demo.onetoone;

import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("ADDRESS")
@Data // lombok
@AllArgsConstructor @NoArgsConstructor
public class Address {

	//@Id
	//private Long id;
	private String building;
	private String street;
	private String state;
	private String country;
	private String zipcode;

}
