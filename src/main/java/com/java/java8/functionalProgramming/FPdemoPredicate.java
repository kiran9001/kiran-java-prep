package com.java.java8.functionalProgramming;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class FPdemoPredicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Predicate
		// 		Represents a predicate (boolean-valued function) of one argument. 
		// boolean test(T t);
		
		Predicate<Integer> isNum = num -> num%1==0;
		Predicate<Integer> isDivBy3 = num -> num%3==0;
		Predicate<Integer> isDivBy5 = num -> num%5==0;
		
		boolean isDvBy15 = isNum.and(isDivBy3).and(isDivBy5).test(30); 
		System.out.println(isDvBy15); // true
		
		Predicate<Integer> isDvBy3or5 = isNum.and(isDivBy3).or(isDivBy5);
		System.out.println("isDvBy3or5 - 41 - "+isDvBy3or5.test(41)); // false
		System.out.println("isDvBy3or5 - 21 - "+isDvBy3or5.test(21)); // true
		
		// BiPredicate
		// 		Represents a predicate (boolean-valued function) of two arguments.
		// boolean test(T t, U u);
		
		BiPredicate<Integer, Boolean> isPrimeIn100 = (num, checkPalindrome)->{
			return isPrimeNum(num) && checkPalindrome(num);
		};
		
		System.out.println( isPrimeIn100.test(191, false) ); // true
		System.out.println( isPrimeIn100.test(191, true) ); // true
		System.out.println( isPrimeIn100.test(183, true) ); // false
		
	}
	private static boolean isPrimeNum(int num) {
		for(int i=2;i<=num/2;i++) {
			if(num%i==0)
				return false;
		}
		return true;
	}
	private static boolean checkPalindrome(int num) {
		String word=String.valueOf(num);
		for(int i=0;i<word.length()/2;i++) {
			if(word.charAt(i)!=word.charAt(word.length()-1-i))
				return false;
		}
		return true;
		
	}


}
