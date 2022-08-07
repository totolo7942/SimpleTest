package com.javabydeveloper.demo;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javabydeveloper.model.User;
import com.javabydeveloper.repository.UserRepository;
import com.javabydeveloper.util.UserType;
import org.springframework.boot.test.mock.mockito.MockBean;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class Spring_boot_H2_test {

//	@Autowired
	@Mock
	private UserRepository userRepository;
	
	@Test
	@DisplayName("Create User Test ")
	void createUserTest() {

		when(userRepository.findById(11L)).thenReturn(java.util.Optional.of(new User("name", "passworD", new Date(), new Date())));

		Optional<User> user = userRepository.findById(11L);

		assertNotNull(user.get() );

//		User created = userRepository.save(getUser());
//		assertNotNull(created);
	}
	
//	private User getUser() {
//
//		User user = new User();
//		user.setUserType(UserType.STUDENT);
//		user.setUserName("PhilipX");
//		user.setPassword("ABC123abc*");
//		user.setDateofBirth(new Date());
//		user.setCreationTime(new Date());
//
//		return user;
//	}
}
