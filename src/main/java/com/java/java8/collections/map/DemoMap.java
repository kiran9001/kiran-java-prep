package com.java.java8.collections.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// key value pairs
		// unordered
		Map<String, Integer> letterCounts = new HashMap<String, Integer>();
		
		String line = "This is my class for learning Map in Java Collections";
		String[] words = line.split(" ");
		for(String word: words)
			letterCounts.put(word, word.length());
		
		letterCounts.forEach((key,value)->System.out.println(key+"-\t"+value));
		
		letterCounts.put(null, 4);
		letterCounts.put(null, 5);
		System.out.println();
		letterCounts.forEach((key,value)->System.out.println(key+"-\t"+value));
		
		// ordered map - LinkedHashMap -- maintains order of insertion
		System.out.println();
		Map<String, Integer> sortedLetterCounts = new LinkedHashMap<String, Integer>();
		String[] wordsUnsorted = Arrays.copyOf(words, words.length);
		Arrays.sort(wordsUnsorted, Comparator.naturalOrder());
		for(String word: wordsUnsorted)
			sortedLetterCounts.put(word, word.length());
		
		sortedLetterCounts.forEach((key,value)->System.out.println(key+"-\t"+value));
		
		// sort by key -- using TreeMap -- inserts according to sorting order
		System.out.println("\n ----sort by key using Tree Map");
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>();
		for(String word: words)
			sortedMap.put(word, word.length());
		sortedMap.forEach((key,value)->System.out.println(key+"-\t"+value));
		
		Map<String, Integer> wordMapUnordered=
				List.of(line.split(" ")).stream().collect(Collectors.toMap(Function.identity(), word->word.length() ));
		wordMapUnordered.forEach((key, value)-> System.out.println(key+"\t-\t"+value));
		
		// sort by key -- using java8
		System.out.println("\n ----sort by key using Java8");
		Map<String, Integer> wordMapOrdered=
				wordMapUnordered.entrySet().stream()
					.sorted(Entry.comparingByKey())  //ascending order
					//.collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)->e2, LinkedHashMap::new));
		wordMapOrdered.forEach((key, value)-> System.out.println(key+"\t-\t"+value));
		//The code passed into to toMap() method is interesting, the first parameter is used as a key, 
		//	the second is used as a value and the third is used to break ties i.e. if two entries are equal then 
		//	which entries will be chosen is decided by the third parameter, here we are using the second entry. 
		//The fourth parameter is the important one, which uses a constructor reference 
		//	to tell Collector that copying a LinkedHashMap should be used. 
        //https://javarevisited.blogspot.com/2017/07/how-to-sort-map-by-keys-in-java-8.html#ixzz7OGcgfFuS
		
		// sort by value -- using java8
		System.out.println("\n ----sort by value using Java8");
		Map<String, Integer> wordMapOrderedByValues=
				wordMapUnordered.entrySet().stream()
					.sorted(Entry.comparingByValue())
					//.collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)->e2, LinkedHashMap::new));
		wordMapOrderedByValues.forEach((key, value)-> System.out.println(key+"\t-\t"+value));
		

		// sort by key -- using java8
		System.out.println("\n ----sort by key DESC using Java8");
		Map<String, Integer> wordMapOrderedByKeyDESC=
				wordMapUnordered.entrySet().stream()
					.sorted(Entry.comparingByKey(Comparator.reverseOrder())) //descending order
					//.collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)->e2, LinkedHashMap::new));
		wordMapOrderedByKeyDESC.forEach((key, value)-> System.out.println(key+"\t-\t"+value));
		
		// char frequency Count
		System.out.println("\n ---- frequency count using Java8");
//		Map<Character, Long> charFrequency = charFrequencyCount(line, "LETTER_FREQ_NOSPACE_ASC");
		Map<Character, Long> charFrequency = charFrequencyCount(line, "LETTER_FREQ_NOSPACE_DESC");
		charFrequency.forEach((key, value) -> System.out.println(key+"\t-\t"+value));
	}
	
	private static Map<Character, Long> charFrequencyCount(String line, String type){
		if("LETTER_FREQ_NOSPACE_ASC".equals(type)) {
			List<Character> chars = new ArrayList<Character>();
			for(char c: line.toLowerCase().replaceAll(" ", "").toCharArray())
				chars.add(c);
			return chars.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		}
		else if("LETTER_FREQ_NOSPACE_DESC".equals(type)) {
			List<Character> chars = new ArrayList<Character>();
			for(char c: line.toLowerCase().replaceAll(" ", "").toCharArray())
				chars.add(c);
			return chars.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		}
		return null;
	}

}
