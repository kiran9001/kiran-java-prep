package com.java.java8.collections.list;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DemoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> scores = new LinkedList<Integer>();
		
		scores.add(1);
		scores.add(1, 2);
		scores.addAll(List.of(3,4));
		scores.addAll(0, List.of(6,7,8));
		
//		for(int score: scores) {
//			System.out.print(score+" ");
//		}
//		System.out.println();
		
//		scores.forEach(System.out::println);  // method reference
		scores.forEach(i->System.out.print(i+" ")); System.out.println();
		
		scores = scores.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		scores.forEach(i->System.out.print(i+" ")); System.out.println();
		
		scores.remove(1);
		scores.forEach(i->System.out.print(i+" ")); System.out.println();
	}

}
