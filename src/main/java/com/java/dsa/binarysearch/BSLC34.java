package com.java.dsa.binarysearch;

public class BSLC34 {

	public static void main(String[] args) {
	
		int[] arr=new int[] {1,2,2,3,3,3,4,4,4,4,5,6,6,7,8,8};
		int target=1;
		
		int[] output=binarySearchRange(arr, target);
		System.out.println("["+output[0]+","+output[1]+"]");
		for(int i=0;i<arr.length;i++)
			System.out.println("a["+i+"]\t:: "+arr[i]);
	}
	
	private static int[] binarySearchRange(int[] arr,int target) {

		return new int[] {
				binarySearchFirstLast(arr, target, true),
				binarySearchFirstLast(arr, target, false)
				};
	}
	
	private static int binarySearchFirstLast(int[] arr, int target,boolean isFirst) {
		
		int start = 0;
		int end = arr.length -1;
		int index=-1;
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(target<arr[mid]) {
				end=mid-1;
			}
			else if(target>arr[mid]) {
				start=mid+1;
			}
			else { //potential answer
				
				index=mid;
				
				if(isFirst) {
					end=mid-1;
				}else {
					start=mid+1;
				}
			}
		}
		
		return index;
	}
	
	
}
