package com.javabydeveloper.spring.demo.filter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabydeveloper.spring.config.filter.ScanCustomTypeFilterConfig;


public class ScanCustomFilterTypeConfigDemo {

    public static void main(String[] args) {
    	ApplicationContext ctxt = new AnnotationConfigApplicationContext(ScanCustomTypeFilterConfig.class);
        
        String[] springComponents = ctxt.getBeanDefinitionNames();
        
        for(String bean : springComponents)
        	System.out.println(bean);  
    }
}
