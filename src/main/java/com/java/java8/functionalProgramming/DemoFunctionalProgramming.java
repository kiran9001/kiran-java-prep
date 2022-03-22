package com.java.java8.functionalProgramming;

import java.util.ArrayList;
import java.util.List;

public class DemoFunctionalProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> persons = fillPersonsList(); // returns immutable list of elements -- cannot modify the list
	
		// Imperative Approach
		System.out.println("Imperative Appraoch");
		List<Person> males = new ArrayList<Person>(); 
		for(Person person: persons) {
			if(Gender.MALE.equals(person.gender))
				males.add(person);
		}
		for(Person male: males) {
			System.out.println(male);
		}
		
		//Declarative Arppraoch -- Neat, Concise  written code 
		System.out.println("\nDeclarative Appraoch");
		persons.stream()
				.filter(person -> Gender.MALE.equals(person.gender))
				.forEach(System.out::println);
				
		
	}

	static class Person{
		private final String name;
		private final Gender gender;
		Person(String name, Gender gender){
			this.name=name;
			this.gender=gender;
		}
		@Override
		public String toString() {
			return this.name+"-"+this.gender;
		}
		
	}
	
	enum Gender{
		MALE,
		FEMALE;
	}
	
	private static List<Person> fillPersonsList() {
		// TODO Auto-generated method stub
		return List.of(
				new Person("kiran", Gender.MALE),
				new Person("alexa", Gender.FEMALE),
				new Person("alan", Gender.MALE),
				new Person("barry", Gender.MALE),
				new Person("vini", Gender.FEMALE),
				new Person("joe", Gender.MALE),
				new Person("katnis", Gender.FEMALE)
			);
	}

}
