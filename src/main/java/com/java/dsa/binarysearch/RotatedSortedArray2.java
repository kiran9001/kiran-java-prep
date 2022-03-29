package com.java.dsa.binarysearch;

public class RotatedSortedArray2 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums= 
//			{4,4,5,6,7,8,8,9,10,11,1,2,2,2,3,3,4};
			{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
						
		int target =
//				4;
				2;
		
		System.out.println(
				search(nums, target)
				);
        
        }        
		
		
	
	
	private static int search(int[] nums, int target) {
		// sorted array >> apply BS
        // step1: find pivot index (smallest in array)
        // step2: apply BS either in [0,pivot-1] or [pivot,L-1]
		// System.out.println(findPivotIndex(arr));
		
		// sorted array >> apply BS
        // step1: find pivot index (smallest in array)
        // step2: apply BS either in [0,pivot-1] or [pivot,L-1]
		
		/*
		int pivot = findPivotIndexS(nums);
        System.out.println("pivot :: "+pivot);
        if(pivot==0)
            return binarySearch(nums,0,nums.length-1, target);
        
        if(target>=nums[0] && target<=nums[pivot-1]) {
            return binarySearch(nums,0,pivot-1, target);
        }else{
            return binarySearch(nums,pivot,nums.length-1, target);
        } 
        */
		int pivot = findPivotIndexL(nums);
		System.out.println("pivot :: "+pivot);
		
		return -1;
	}
	
	private static int binarySearch(int[] arr, int start, int end, int target) {
		
        if(arr.length==1)
            return arr[0]!=target?-1:0; 
            
        
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(target<arr[mid]) {
				end=mid-1;
			}else if(target>arr[mid]) {
				start=mid+1;
			}else { // target == arr[mid]
				return mid;
			}
		}
			
		return -1;
	}

	private static int findPivotIndexS(int[] arr) {
		
		// pivot index (smallest in array)
		int start=0;
		int end=arr.length-1;
		while(start<end) {
			int mid=start+(end-start)/2;
			if(arr[mid]>arr[end]) { 
				// [weird] mid value > end value
				// then, smallest value will present right half
				start=mid+1;
			}else {
				// [normal] mid value < end value
				// then, smallest value will present left half
				end=mid;
			}
		}
		return start;
	}
	
	private static int findPivotIndexL(int[] arr) {
		
		// pivot index (largest in array)
		int start=0;
		int end=arr.length-1;
		while(start<end) {
			int mid=start+(end-start)/2;
			if(arr[mid]>arr[end]) { 
				// [weird] mid value > end value
				// then, smallest value will present right half
				start=mid;
			}else {
				// [normal] mid value < end value
				// then, smallest value will present left half
				end=mid-1;
			}
		}
		return start;
	}
}

