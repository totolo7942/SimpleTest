package com.javabydeveloper.demo.template.auto_gen_keys;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.javabydeveloper.base.BaseTest;
import com.javabydeveloper.model.User;
import com.javabydeveloper.template.UserSimpleJdbcInsert;
import com.javabydeveloper.util.UserType;

@SpringBootTest
@Sql(scripts = "/basic_mapping.sql") // to created DB tables and init sample DB data
@TestMethodOrder(value = OrderAnnotation.class) // to run tests in order
public class JdbcAutoGenerated_KeysTest extends BaseTest {

	@Autowired
	private UserSimpleJdbcInsert jdbcTemplate;

	@Test
	@DisplayName("Retrieve_auto_generated_key_Test1")
	@Order(1)
	void autoGeneratedKey_1_Test() {

		long id = jdbcTemplate.save(getUser());
		
		System.out.println("Auto-Generated-Key: "+id);
		assertTrue(id == 13);
	}
	
	@Test
	@DisplayName("Retrieve_auto_generated_key_Test2")
	@Order(2)
	void autoGeneratedKey_2_Test() {

		User user = getUser();
		user.setUserName("MullerMax");
		long id = jdbcTemplate.saveWithSimpleJdbcInsert(user);
		
		System.out.println("Auto-Generated-Key: "+id);
		assertTrue(id == 13);
	}

	
	private User getUser() {

		User user = new User();
		user.setUserType(UserType.STUDENT);
		user.setUserName("PhilipX");
		user.setPassword("ABC123abc*");
		user.setDateofBirth(new Date());
		user.setCreatedTime(new Date());

		return user;
	}
}
