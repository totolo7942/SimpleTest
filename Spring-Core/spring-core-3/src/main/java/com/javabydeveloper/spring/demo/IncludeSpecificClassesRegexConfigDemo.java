package com.javabydeveloper.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabydeveloper.spring.config.IncludeSpecificClassesRegexConfig;


public class IncludeSpecificClassesRegexConfigDemo {

	 public static void main(String[] args) {
	    	ApplicationContext ctxt = new AnnotationConfigApplicationContext(IncludeSpecificClassesRegexConfig.class);
	        
	        String[] springComponents = ctxt.getBeanDefinitionNames();
	        
	        for(String bean : springComponents)
	        	System.out.println(bean);  
	    }
}
