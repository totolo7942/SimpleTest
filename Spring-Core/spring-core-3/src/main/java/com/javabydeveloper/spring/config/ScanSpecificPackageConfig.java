package com.javabydeveloper.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.javabydeveloper.spring.bean.animal.amphibians")
public class ScanSpecificPackageConfig {

}
