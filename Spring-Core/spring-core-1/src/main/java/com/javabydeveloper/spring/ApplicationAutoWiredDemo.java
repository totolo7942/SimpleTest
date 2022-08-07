package com.javabydeveloper.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabydeveloper.spring.autowire.AutowireByNameTestService;
import com.javabydeveloper.spring.autowire.AutowireByQualifierTestService;
import com.javabydeveloper.spring.autowire.AutowireByTypeTestService;
import com.javabydeveloper.spring.autowire.AutowireCustomMethodDITestService;
import com.javabydeveloper.spring.autowire.AutowireDITestService;
import com.javabydeveloper.spring.autowire.OptionalDITestService;
import com.javabydeveloper.spring.config.AppConfigForAutowired;

public class ApplicationAutoWiredDemo {

	 
    public static void main(String[] args) {
    	
    	ApplicationContext ctxt = new AnnotationConfigApplicationContext(AppConfigForAutowired.class);
        
        AutowireDITestService adits = ctxt.getBean(AutowireDITestService.class);
        adits.test();
        
        AutowireCustomMethodDITestService acmdits = ctxt.getBean(AutowireCustomMethodDITestService.class);
        acmdits.test();
        
        AutowireByNameTestService abnts = ctxt.getBean(AutowireByNameTestService.class);
        abnts.printResults();
        
        AutowireByTypeTestService abtts = ctxt.getBean(AutowireByTypeTestService.class);
        abtts.printResults();
        
        AutowireByQualifierTestService abqts = ctxt.getBean(AutowireByQualifierTestService.class);
        abqts.printResults();
        
        OptionalDITestService odis = ctxt.getBean(OptionalDITestService.class);
        odis.doStuff();
    }
}
