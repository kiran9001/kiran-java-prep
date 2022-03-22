package com.java.java8.functionalProgramming;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FPdemoFunction {

	public static void main(String[] args) {
		
		// https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
		
		// Function<T, R> 
		// R apply(T t);

		//		T - input type parameter of function
		//		R - Return type of function
		
		
		Function<String,Boolean> isOdd = (num)-> Integer.parseInt(num)%2!=0;
		Function<String,Boolean> isEven = (num)-> Integer.parseInt(num)%2==0;
		
		System.out.println(isOdd.apply("123")); // true
		System.out.println(isOdd.apply("124")); // false
		
		
		// Predicate
		// 		Represents a predicate (boolean-valued function) of one argument. 
		// boolean test(T t);
		
		Predicate<String> isOddPredicate = (num)-> Integer.parseInt(num)%2!=0;
		System.out.println(isOddPredicate.test("1234")); //false
		
		// BiFunction
		// 		Represents a function that accepts two arguments and produces a result
		// R apply(T t, U u);
		
		// check odd and prime
		BiFunction<Integer, Boolean, Boolean> isOddPrimeWithBiFunction = (num, checkPrime)-> {
			
			if(checkPrime) {
				for(int i=2;i<num/2;i++) {
					if(num%i==0)
						return false;
				}
				return num%2!=0;
			}else {
				return num%2!=0;
			}
		};
		System.out.println(isOddPrimeWithBiFunction.apply(7,true));
		
		// function chaining of different methods
		
		// increment by 1
		Function<Integer,Integer> incrementBy1 = num -> num++;
		// multiply by 10
		Function<Integer,Integer> multiplyBy10 = num -> num*10;
		// combining both functions
		Function<Integer, Integer> add1Multiply10 = incrementBy1.andThen(multiplyBy10);
		System.out.println(add1Multiply10.apply(1)); // 20
		
		
	}
}
