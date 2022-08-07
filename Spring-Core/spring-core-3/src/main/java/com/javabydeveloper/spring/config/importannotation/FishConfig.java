package com.javabydeveloper.spring.config.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javabydeveloper.spring.bean.animal.fish.GoldFish;
import com.javabydeveloper.spring.bean.animal.fish.Guppy;
import com.javabydeveloper.spring.bean.animal.fish.Salmon;

@Configuration
public class FishConfig {

	@Bean
	public GoldFish goldFish() {
		return new GoldFish();
	}
	
	@Bean
	public Guppy guppy() {
		return new Guppy();
	}
	
	@Bean
	public Salmon salmon() {
		return new Salmon();
	}
	
}
