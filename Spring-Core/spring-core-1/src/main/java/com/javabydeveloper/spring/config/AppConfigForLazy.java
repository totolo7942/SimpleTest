package com.javabydeveloper.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.javabydeveloper.spring.lazy.Company;
import com.javabydeveloper.spring.lazy.Customer;
import com.javabydeveloper.spring.lazy.Employee;

import lombok.val;

@Lazy
@Configuration
@ComponentScan("com.javabydeveloper.spring.lazy")
public class AppConfigForLazy {

	@Bean
    public Company companyBean(){
        return new Company();
    }

    @Bean
    public Employee employeeBean(){
        return new Employee();
    }
    
    @Lazy(value = false)
    @Bean
    public Customer customerBean(){
        return new Customer();
    }
}
