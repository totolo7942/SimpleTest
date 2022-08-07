package com.javabydeveloper.demo.onetoone;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.javabydeveloper.base.BaseTest;
import com.javabydeveloper.util.UserType;

@Sql(scripts = "/one-to-one-mapping.sql")
@SpringBootTest
public class OneToOneMappingTest extends BaseTest {

	@Autowired
	private UserOneToOneTestRepository userTestRepository;
	
	@Autowired
	private CustomerOneToOneTestRepository customerOneToOneTestRepository;

	@Test
	@DisplayName("One-to-One Mapping Test1")
	void oneToOne_MappingTest1() {

		Address address = new Address();
		address.setBuilding("102, North Wing, Lotus Avenue");
		address.setStreet("Parklane, Los Angeles");
		address.setState("California");
		address.setCountry("United States");
		address.setZipcode("90011");

		Customer book = new Customer();
		book.setName("Peter");
		book.setMembership("FREE");
		book.setAddress(address);

		Customer saved = customerOneToOneTestRepository.save(book);
		System.err.println(saved);
		Assertions.assertTrue(saved != null);
		
		Optional<Customer> loaded = customerOneToOneTestRepository.findById(1L);
		System.err.println(loaded.get());
		Assertions.assertTrue(loaded != null);
	}

	@Test
	@DisplayName("One-to-One Mapping Test2")
	//@Sql(scripts = "/one-to-one-mapping.sql")
	void oneToOne_MappingTest2() {

		Credentials credentials = new Credentials();
		credentials.setUserName("peterm");
		credentials.setPassword("password");

		User user = new User();
		user.setCreatedTime(new Date());
		user.setDateofBirth(new Date());
		user.setUserType(UserType.EMPLOYEE);
		user.setCredentials(credentials);

		User createdUser = userTestRepository.save(user);
		System.err.println(createdUser);
		Assertions.assertTrue(createdUser != null);
		
		Optional<User> loaded = userTestRepository.findById(1L);
		System.err.println(loaded.get());
		Assertions.assertTrue(loaded != null);
	}
}
