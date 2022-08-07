package com.javabydeveloper.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.javabydeveloper.base.BaseTest;
import com.javabydeveloper.model.User;
import com.javabydeveloper.repository.UserRepository;
import com.javabydeveloper.util.UserType;

@SpringBootTest
@Sql(scripts = "/basic_mapping.sql") // to create DB tables and init sample DB data
@TestMethodOrder(value = OrderAnnotation.class) // to run tests in order
public class Basic_Mapping_Test extends BaseTest {

	@Autowired
	private UserRepository userRepository;

	//@Disabled
	@Test
	@DisplayName("Create-User-Test ")
	@Order(1)
	void createUserTest() {

		userRepository.deleteAll();// clearing all the records from database
		
		User created1 = userRepository.save(getUser("Peter"));
		User created2 = userRepository.save(getUser("Philip"));
		User created3 = userRepository.save(getUser("Martin"));
	
		Assertions.assertTrue(created1 != null && created1.getId() != null);
		Assertions.assertTrue(created2 != null && created2.getId() != null);
		Assertions.assertTrue(created3 != null && created3.getId() != null);
	}

	//@Disabled
	@Test
	@DisplayName("Update-User-Test ")
	@Order(2)
	void updateUserTest() {

		// Read all users
		List<User> allUsers = (List<User>) userRepository.findAll();

		allUsers.forEach(user -> {
			user.setPassword("ABC123abc#");
			User updated = userRepository.save(user);

			Assertions.assertTrue(updated.getPassword().equals("ABC123abc#"));
		});

		// userRepository.saveAll(allUsers); // batch update
	}

	//@Disabled
	@Test
	@DisplayName("Delete-User-Test ")
	@Order(4)
	void deleteUserTest() {

		// Read all users
		List<User> allUsers = (List<User>) userRepository.findAll();

		allUsers.forEach(user -> {
			userRepository.delete(user);

			Assertions.assertTrue(!userRepository.findById(user.getId()).isPresent());
		});

		// userRepository.deleteAll(allUsers); //batch delete
	}

	// MySql stored procedure test
	@Disabled("Enable to run On MySql only")
	@Test @Order(3)
	@Sql(scripts = "/stored_procedures.sql", config = @SqlConfig(encoding = "utf-8", separator = "$"))
	@DisplayName("Stored Procedure Test ")
	void callStoredProcedureTest() {

		List<User> users = userRepository.searchUsersByName("Pet");

		System.out.println(users);
		users.forEach(u -> Assertions.assertTrue(u.getUserName().contains("Pet")));

		int users_found = userRepository.countSearchUsersByName("pet");
		System.out.println(users_found);
		Assertions.assertTrue(users_found == 4);
	}
	
	//@Disabled
	@Test @Order(5)
	@DisplayName("Spring Data JDBC Update Query ")
	void upDateQueryTest() {

		boolean isUpdated = userRepository.updateUserName("PeterZ", 1L);
		Assertions.assertTrue(isUpdated);
		
		Assertions.assertTrue(userRepository.findById(1L).get().getUserName().equals("PeterZ"));
	}

	private User getUser(String userName) {

		User user = new User();
		user.setUserType(UserType.STUDENT);
		user.setUserName(userName);
		user.setPassword("ABC123abc*");
		user.setDateofBirth(new Date());
		user.setCreatedTime(new Date());

		return user;
	}
}
