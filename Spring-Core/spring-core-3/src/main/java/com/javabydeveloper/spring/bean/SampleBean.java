package com.javabydeveloper.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;

import com.javabydeveloper.spring.bean.animal.birds.Eagle;
import com.javabydeveloper.spring.bean.animal.birds.Ostrich;
import com.javabydeveloper.spring.bean.animal.fish.GoldFish;

public class SampleBean {
	
	@Autowired
	private GoldFish goldFish;
	
	@Autowired
	private Eagle eagle;
	
	@Autowired
	private Ostrich ostrich;
	
	public void printObjects() {
		System.out.println("---------- Print SampleBean Objects ----------");
		System.out.println(goldFish);
		System.out.println(eagle);
		System.out.println(ostrich);
	}
	
}
