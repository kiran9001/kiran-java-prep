package com.java.java8.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DemoArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<Integer> list =
////			List.of();
////			List.of(1,2,3);
//			new ArrayList<Integer>();
//		for(int i=0;i<10;i++) {
//			list.add((int) (Math.random()*10));
//		}
//		iterateForEachLoop(list);
				
//		iterateUsingIterator(list);

//		Collections.sort(list); // ascending order
//		Collections.sort(list, Collections.reverseOrder()); // descending order
//		list.sort(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o1.compareTo(o2);
//			}
//		});  // ascending order
//		list.sort(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o2.compareTo(o1);
//			}
//			
//		}); // descending order
//		
//		iterateForEachLoop(list);
		
		List<String> names = new ArrayList<String>();
		names.add("kiran");
		names.add(null);
		names.add("coder");
		names.add("mahesh");
		names.add(null);
		names.add("tristirc");
		names.add("India");
		
		iterateForEachLoop(names);
		
//		names.sort(new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				// return o1.compareTo(o2); 
//				return o1.compareToIgnoreCase(o2);
//			}
//		});
//		names.sort(Comparator.reverseOrder()); //descending order without null values
//		names.sort(Comparator.naturalOrder()); // ascending order without null values
//		names.sort(Comparator.nullsFirst(Comparator.naturalOrder())); // null null [sorted list]
//		names.sort(Comparator.nullsLast(Comparator.naturalOrder())); //  [sorted list] null null
//		names=names.stream().filter(t->t!=null).collect(Collectors.toList()); // filter null values
//		names=names.stream().filter(t->t!=null).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//		names=names.stream().filter(t->t!=null).sorted(new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
////				return o1.compareTo(o2);
//				return o1.compareToIgnoreCase(o2);
//			}
//		}).collect(Collectors.toList());
		iterateForEachLoop(names);
	}
	
	private static <E> void iterateForEachLoop(List<E> list) {
		// iteration of list
		// iteration -- for each loop
		for(E i: list) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	private static void iterateUsingIterator(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();
		int i=0;
		while(iterator.hasNext()) {
					
			System.out.println(iterator.next());
			i++;
			if(i%2==0)
				iterator.remove();
		}
	}

}
