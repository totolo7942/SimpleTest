package com.javabydeveloper.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.javabydeveloper.spring.bean.animal.amphibians.Frog;
import com.javabydeveloper.spring.bean.animal.reptiles.snakes.BlackMamba;

@Configuration
@ComponentScan(basePackageClasses = {BlackMamba.class, Frog.class})
public class ScanBasePackageClassesConfig {

}
