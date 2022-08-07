package com.javabydeveloper.spring.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.javabydeveloper.spring.bean.Animal;
import com.javabydeveloper.spring.component.Fruit;

public class CollectionTestBean {

	private List<String> namesList;

	@Autowired
	private List<Animal> animalList;
	
	@Autowired
	private Set<String> namesSet;

	@Autowired
	@Qualifier("nonFerciousAnimals")
	private List<Animal> nonFerciousAnimals;

	@Autowired
	private List<Fruit> fruitList;

	private Map<Integer, String> namesMap;

	@Autowired
	private String[] namesArray;


	@Autowired
	public void setNamesMap(Map<Integer, String> namesMap) {
		this.namesMap = namesMap;
	}

	public CollectionTestBean(List<String> namesList) {
		this.namesList = namesList;
	}

	public void printList() {
		System.out.println("printList:"+namesList);
	}
	
	public void printNamesSet() {
		System.out.println("printNamesSet:"+namesSet);
	}

	public void printFruitList() {
		System.out.println("printFruitList:"+fruitList);
	}

	public void printAnimalList() {
		System.out.println("printAnimalList:"+animalList);
	}

	public void printNoFerociousAnimalList() {
		System.out.println("printNoFerociousAnimalList:"+nonFerciousAnimals);
	}

	public void printNamesMap() {
		System.out.println("printNamesMap:"+namesMap);
	}

	public void printNamesArry() {
		System.out.println("printNamesArray:"+Arrays.asList(namesArray));
	}

}
