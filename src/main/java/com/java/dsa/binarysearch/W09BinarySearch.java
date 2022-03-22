package com.java.dsa.binarysearch;

public class W09BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("dkjzn");
		int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        
		int target = -50;
        
		int ans = binarySearch(arr, target);
        System.out.println(ans);
        
        System.out.println("ceiling index\t:: "+ binarySearchCeiling(arr, target));
        System.out.println("ceiling\t:: "+ arr[binarySearchCeiling(arr, target)]);
        
        System.out.println("floor index\t:: "+ binarySearchFloor(arr, target));
        System.out.println("floor\t:: "+ arr[binarySearchFloor(arr, target)]);
        
	}

	private static int binarySearch(int[] arr, int target) {
		
		int start = 0;
		int end = arr.length -1;
		int mid;
		
		while(start<=end) {
			mid = start + (end-start)/2;
			if(target<arr[mid]) {
				end=mid-1;
			}
			else if(target>arr[mid]) {
				start=mid+1;
			}
			else { // target = arr[mid]
				return mid;
			}
		}
		
		return -1;
	}
	
private static int binarySearchCeiling(int[] arr, int target) {
		
		int start = 0;
		int end = arr.length -1;
		int mid;
		
		while(start<=end) {
			mid = start + (end-start)/2;
			if(target<arr[mid]) {
				end=mid-1;
			}
			else if(target>arr[mid]) {
				start=mid+1;
			}
			else { // target = arr[mid]
				return mid;
			}
		}
		
		return start;
	}

private static int binarySearchFloor(int[] arr, int target) {
	
	int start = 0;
	int end = arr.length -1;
	int mid;
	
	while(start<=end) {
		mid = start + (end-start)/2;
		if(target<arr[mid]) {
			end=mid-1;
		}
		else if(target>arr[mid]) {
			start=mid+1;
		}
		else { // target = arr[mid]
			return mid;
		}
	}
	
	return end;
}


}
