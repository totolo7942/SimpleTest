package com.javabydeveloper.spring.bootxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.javabydeveloper.spring.bean.ExampleBean;
import com.javabydeveloper.spring.bean.SampleBean;

@SpringBootApplication
@ImportResource("classpath:beans-context.xml")
public class SpringBootXmlBeansDemoApp implements CommandLineRunner{
	
	@Autowired
	private ExampleBean exampleBean;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(SpringBootXmlBeansDemoApp.class, args);
		
		SampleBean sampleBean = ctxt.getBean(SampleBean.class);
		System.out.println("*********"+sampleBean+"*********");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-----"+exampleBean+"---------");
	}

}
