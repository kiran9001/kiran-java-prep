package com.java.java8.functionalProgramming;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class FPdemoSupplier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Supplier
		// 		Represents a supplier of results. 
		// T get();
		
		System.out.println(getDBConnectionURLSupplier.get()); // returns jdbc url string
		
		// IntSupplier
		// int getAsInt();
		IntSupplier intSupplierDemo = ()->{
			return 121;
		};
		System.out.println(intSupplierDemo.getAsInt()); // 121
		
		// LongSupplier
		// long getAsLong();
		LongSupplier longSupplierDemo = ()->{
			return 100;
		};
		System.out.println(longSupplierDemo.getAsLong()); // 100
		
		// BooleanSupplier
		// boolean getAsBoolean();
		BooleanSupplier booleanSupplierDemo = ()->{
			return false;
		};
		System.out.println(booleanSupplierDemo.getAsBoolean()); // false
		
	}

	private static String getDBConnectionURL() {
		return "jdbc://localhost:4840/users";
	}
	
	private static Supplier<String> getDBConnectionURLSupplier = () -> "jdbc://localhost:4840/users";
}
