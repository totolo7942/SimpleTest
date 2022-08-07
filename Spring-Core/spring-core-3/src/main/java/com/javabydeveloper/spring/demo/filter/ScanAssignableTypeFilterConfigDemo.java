package com.javabydeveloper.spring.demo.filter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabydeveloper.spring.config.filter.ScanAssignableTypeFilterConfig;


public class ScanAssignableTypeFilterConfigDemo {

    public static void main(String[] args) {
    	ApplicationContext ctxt = new AnnotationConfigApplicationContext(ScanAssignableTypeFilterConfig.class);
        
        String[] springComponents = ctxt.getBeanDefinitionNames();
        
        for(String bean : springComponents)
        	System.out.println(bean);  
    }
}
