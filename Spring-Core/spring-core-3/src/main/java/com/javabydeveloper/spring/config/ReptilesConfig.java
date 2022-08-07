package com.javabydeveloper.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.javabydeveloper.spring.bean.animal.reptiles")
public class ReptilesConfig {

}
