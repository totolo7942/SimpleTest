package com.javabydeveloper.demo.template;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import com.javabydeveloper.base.BaseTest;
import com.javabydeveloper.model.User;

@SpringBootTest
@Sql(scripts = "/basic_mapping.sql") // to created DB tables and init sample DB data
@TestMethodOrder(value = OrderAnnotation.class) // to run tests in order
public class JdbcTemplateQueryForObjectTest extends BaseTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//@Disabled
	@Test
	@DisplayName("users-count-test")
	@Order(1)
	void usersCountTest() {
		
		String sql = "SELECT count(*) FROM USER";
		
		int total = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(total);
		assertTrue(total == 12);
	}
	
	@Order(2)
	@DisplayName("find-by-id-test")
	@ParameterizedTest
	@ValueSource(longs = {11})
	void findByIdTest(Long id) {
		
		String sql = "SELECT * FROM USER where ID = ?";
		
		Optional<User> user = Optional.ofNullable(jdbcTemplate.queryForObject(sql, new Object[] {id},  new UserMapper()));
		assertTrue(user.get().getId().equals(id));
	}

	@Disabled("Run on Mysql only")
	@Order(3)
	@DisplayName("srong-password-test")
	@ParameterizedTest
	@ValueSource(strings = {"PeterM"})
	void userHasStrongPasswordTest(String name) {
		
		String sql = "SELECT IF((SELECT LENGTH(password) FROM USER where USERNAME=?) > 6, true, false)";
		
		boolean hasStrongPassword = jdbcTemplate.queryForObject(sql, new Object[] {name},  Boolean.class);
		
		assertTrue(hasStrongPassword);
	}

}
