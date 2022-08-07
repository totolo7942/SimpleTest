package com.javabydeveloper.spring.config.importannotation.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.javabydeveloper.spring.bean.animal.reptiles.crocodles")
public class CrocodleConfig {

}
