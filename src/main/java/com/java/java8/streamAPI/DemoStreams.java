package com.java.java8.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class DemoStreams {

	public static void main(String[] args) {
		
		int[] arr= {4,1,6,3,6,0,12,31,70,51};
		
		System.out.println(
				
		Arrays.stream(new int[] {1,2,3,4,5})
				.sum() // 1+2+3+4+5 = 15
//				.average() // 3.0 (optionalDouble)
//				.count() // no.of elements
//				.reduce(0, (acc,b) -> acc+b ) // 15
//				.reduce(1, (acc,b) -> acc*b) // 120
//				.reduce(Integer::sum) // 15
//				.reduce(1, Integer::sum) // 16
//				.reduce(0, Integer::max) // 5
//				.reduce(0, (a, b) -> a > b ? a : b) // 5
//				.reduce(0, (a, b) -> a < b ? a : b) // 0
//		       	.forEach(System.out::println);
		
		);
		

		
		IntStream.rangeClosed(1, 10)
					.filter(i->i%2==0)
					.forEach(System.out::println);
		
		String str="hi there, how you doing?";
		IntStream.range(0, str.length())
					.filter(c-> {
							return
								(str.charAt(c)>='a'&& str.charAt(c)<='z') || 
								(str.charAt(c)>='A'&& str.charAt(c)<='Z') ;
								}
							);
					
}


}