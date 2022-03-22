package com.java.dsa.binarysearch;

public class BSLC744 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] lettters = {'c','f','j'};
		char target='d';
		System.out.println(nextGreatestLetter(lettters, 'a'));
		System.out.println(nextGreatestLetter(lettters, 'c'));
		System.out.println(nextGreatestLetter(lettters, 'd'));
		System.out.println(nextGreatestLetter(new char[] {'a','b'}, 'z'));
	}
	
	public static char nextGreatestLetter(char[] letters, char target) {
		
		int start =0;
		int end = letters.length-1;
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(target>=letters[mid])
				start=mid+1;
			else if(target<letters[mid])
				end=mid-1;
		}
		
		if(start>=0 && start<letters.length)
			return letters[start];
		else
			return letters[0];
		
	}

	 public static int nextGreatestLetterTest(char[] letters, char target) {
	     // a to z then starts a again
		 int[] intLetters = new int[letters.length];
		 int index=0;
		 
		 for(char letter: letters) 
			 intLetters[index++]=letter-'a';
		 
		 for(int l: intLetters)
			 System.out.print(l+" ");
		 System.out.println();
		 
		 int intTarget=target-'a';
		 int start=0;
		 int end=intLetters.length-1;
		 
		 while(start<=end) {
			 int mid=start+(end-start)/2;
			 if(intTarget>intLetters[mid])
				 start=mid+1;
			 else if(intTarget<intLetters[mid])
				 end=mid-1;
			 else
				 break;
		 }
		 
		 return intLetters[start];
	    }
}
