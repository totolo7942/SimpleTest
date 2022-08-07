package com.javabydeveloper.spring.collection;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.javabydeveloper.spring.bean.Animal;

@Configuration
public class CollectionBeanConfig {
	
	@Bean
	public CollectionTestBean getCollectionTestBean() {
		return new CollectionTestBean(namesList());
	}
	
	@Bean
	public String[] namesArray() {
		return new String[] {"Peter", "John", "Anand", "Gerhard"};
	}
	

	@Bean
	public List<String> namesList() {
		return Arrays.asList("Peter", "John", "Anand", "Gerhard");
	}
	
	// Unmodifiable set
	@Bean
	public Set<String> namesSet() {
		return Set.of("Peter", "John", "Anand", "Gerhard");
	}
	
	@Bean
	public Map<Integer, String> namesMap() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Peter");
		map.put(2, "John");
		map.put(3, "Anand");
		map.put(4, "Gerhard");
		
		return map;
	}
	
	@Bean
	public Animal getTiger() {
		return new Animal("Tiger");
	}
	
	@Bean
	@Order(1)
	@Qualifier("nonFerciousAnimals")
	public Animal getDeer() {
		return new Animal("Deer");
	}
	
	@Bean
	@Qualifier("nonFerciousAnimals")
	public Animal getKangaroo() {
		return new Animal("Kangaroo");
	}
	
	@Bean
	@Order(2)
	public Animal getFox() {
		return new Animal("Fox");
	}
}
