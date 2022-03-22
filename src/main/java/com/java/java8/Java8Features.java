package com.java.java8;

import java.util.Optional;

public class Java8Features {

	public static void main(String[] args) {
		
		prepOptionalClass();

	}

	private static void prepOptionalClass() {
		
		// Optional class
		Optional<String> optionalString = Optional.of("optionalStringValue");
		
		// If a value is present, returns the value, otherwise throws NoSuchElementException.
		optionalString.get(); //optionalStringValue
		optionalString.orElse("defaultValue"); //optionalStringValue
		optionalString.isEmpty(); // false
		optionalString.isPresent(); //true
		
		//If a value is present, returns the value, otherwise returns the result produced by the supplying function.
		//  java.util.Optional.orElseGet(Supplier<? extends String> supplier)
		optionalString.orElseGet(()->{
			return "optionalValueFromSupplier";
		});
		
		optionalString.ifPresentOrElse(
				//action if present
				(value)->{
					System.out.println("value present in optional :: "+value);
				}, 
				// action if not present -- else part
				()->{
					System.out.println("this executed if null/empty values");
				});
		
		System.out.println();
				
		
		
	}

}
