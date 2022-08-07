package com.javabydeveloper.spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.javabydeveloper.spring.autowire.AutowireByNameTestService;
import com.javabydeveloper.spring.autowire.AutowireByQualifierTestService;
import com.javabydeveloper.spring.autowire.AutowireByTypeTestService;
import com.javabydeveloper.spring.autowire.AutowireCustomMethodDITestService;
import com.javabydeveloper.spring.autowire.AutowireDITestService;
import com.javabydeveloper.spring.autowire.OptionalDITestService;
import com.javabydeveloper.spring.config.bean.BootTestBean;

@SpringBootApplication
public class SpringBootAutowiredDemoApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(SpringBootAutowiredDemoApp.class, args);

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
		
		BootTestBean bootTestBean = ctxt.getBean(BootTestBean.class);
		System.out.println("------ Beans in Sub Directory for Boot App---------");
		System.out.println(bootTestBean);
	}
}
