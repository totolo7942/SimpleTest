package com.javabydeveloper.demo.onetoone;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("CUSTOMER")
public class Customer {

	@Id
	private Long id;
	private String name;
	private String membership;
	private Address address;

}
