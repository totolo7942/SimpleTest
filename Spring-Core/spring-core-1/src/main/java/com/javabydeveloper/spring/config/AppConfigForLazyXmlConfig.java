package com.javabydeveloper.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:lazy-beans-context.xml")
public class AppConfigForLazyXmlConfig {

}
