package com.java.dsa.binarysearch;

public class RotatedSortedArray1 {

	public static void main(String[] args) {
		// without finding pivot value
		int[] nums= {4,5,6,7,0,1,2};
		int target =3;
		System.out.println( findTargetRotatedSorted(nums, target) );
	}

	private static int findTargetRotatedSorted(int[] nums, int target) {
		
		int start=0;
		int end=nums.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(nums[mid]==target) // found target
				return mid; 
			if(nums[start]<=nums[mid]) { // [start ... mid] sorted
				if(nums[start] <= target && nums[mid]>=target)
					end=mid-1;
				else
					start=mid+1;
			}else { // [mid+1 ... end] or (mid ... end] sorted
				if(nums[mid]<target && nums[end]>=target)
					start=mid+1;
				else
					end=mid-1;
			}
		}
		
		return -1;
	}

}
