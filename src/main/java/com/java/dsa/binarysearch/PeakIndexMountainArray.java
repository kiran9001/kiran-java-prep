package com.java.dsa.binarysearch;

public class PeakIndexMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5,6,7,6,3,2};
//		int[] arr= {1,2,3,4,5,6,7};
		System.out.println(peakInMountainArray(arr));
	}
	
	private static int peakInMountainArray(int[] arr) {
		
		// sorted >> apply binary search
		// ascending from 'start' to 'peak-index'
		// descending from 'peak-index' to 'end'
		
		// no target value to search in binary array
		// checking condition 
		//		check whether peak arrived or not at mid element
		
		int start=0;
		int end=arr.length-1;
		while(start<end) {
			int mid=start+(end-start)/2;
			if(arr[mid]<arr[mid+1]) { 
				// is ascending part of the array
				// this is because we know that mid-1 element > mid element
				start=mid+1;
			}else if(arr[mid]>arr[mid+1]) { 
				// is peak (or) descending part of array
				// mid may be the answer, but still look to left
				// this is why end != mid-1
				end=mid;
			}
		}
		
		// loop breaks at start<end i.e start=end
		// pointing to the largest element in the array
		// start and end are always trying to find the max element in the above 2 checks
		return start;
	}

}
