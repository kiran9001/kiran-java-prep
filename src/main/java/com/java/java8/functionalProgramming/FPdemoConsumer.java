package com.java.java8.functionalProgramming;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class FPdemoConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// Consumer
		// void accept(T t);
		
		// Represents an operation that
		//		accepts a single input argument and returns noresult.
		
		
		// Unlike most other functional interfaces, Consumer is expected 
		//		 operate via side-effects. 
		
		Consumer<String>  consumerDemo = num -> {
			System.out.println(Integer.parseInt(num));
		};
		consumerDemo.accept("12345"); // prints in console
//		consumerDemo.accept("ttd3425"); // exception
		
		
		// BiConsumer
		// void accept(T t, U u);
		
		BiConsumer<String, Boolean> consumerDemo2 = (name, isAdult)->{
			if(isAdult)
				System.out.println("Eligible for Vote");
			else
				System.out.println("Ineligible. Try next time");
		};
		consumerDemo2.accept("alan", true);	// Eligible for Vote
		consumerDemo2.accept("joe", false); // Ineligible. Try next time
		
		
		
	}

}
