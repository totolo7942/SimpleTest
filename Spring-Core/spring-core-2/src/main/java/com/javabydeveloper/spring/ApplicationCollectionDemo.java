package com.javabydeveloper.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabydeveloper.spring.collection.CollectionBeanConfig;
import com.javabydeveloper.spring.collection.CollectionTestBean;
import com.javabydeveloper.spring.collection.FruitConfig;

public class ApplicationCollectionDemo {
	
	public static void main(String[] args) {
		
		ApplicationContext ctxt = new AnnotationConfigApplicationContext(CollectionBeanConfig.class, FruitConfig.class);
		
		CollectionTestBean collectionTestBean = ctxt.getBean(CollectionTestBean.class);
		
		collectionTestBean.printList();
		collectionTestBean.printNamesSet();
		collectionTestBean.printFruitList();
		collectionTestBean.printAnimalList();
		collectionTestBean.printNoFerociousAnimalList();
		collectionTestBean.printNamesMap();
		collectionTestBean.printNamesArry();
	}
}
