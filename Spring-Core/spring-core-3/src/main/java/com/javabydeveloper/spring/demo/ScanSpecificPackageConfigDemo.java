package com.javabydeveloper.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabydeveloper.spring.config.ScanSpecificPackageConfig;


public class ScanSpecificPackageConfigDemo {

	 public static void main(String[] args) {
	    	ApplicationContext ctxt = new AnnotationConfigApplicationContext(ScanSpecificPackageConfig.class);
	        
	        String[] springComponents = ctxt.getBeanDefinitionNames();
	        
	        for(String bean : springComponents)
	        	System.out.println(bean);  
	    }
}
