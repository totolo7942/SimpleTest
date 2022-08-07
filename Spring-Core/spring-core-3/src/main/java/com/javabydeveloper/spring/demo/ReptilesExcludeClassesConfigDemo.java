package com.javabydeveloper.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabydeveloper.spring.config.ReptilesExcludeClassesConfig;


public class ReptilesExcludeClassesConfigDemo {

    public static void main(String[] args) {
    	ApplicationContext ctxt = new AnnotationConfigApplicationContext(ReptilesExcludeClassesConfig.class);
        
        String[] springComponents = ctxt.getBeanDefinitionNames();
        
        for(String bean : springComponents)
        	System.out.println(bean);  
    }
}
