package com.javabydeveloper.spring.config.filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.javabydeveloper.spring.bean.animal.reptiles",
        useDefaultFilters = false,
		includeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, 
		pattern = "*..*Cobra && !(*..Mono*)"))
// pattern = "*..Black* || *..E*)"
public class ScanAspectJFilterConfig {

}
