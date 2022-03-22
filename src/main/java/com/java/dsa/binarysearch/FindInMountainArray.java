package com.java.dsa.binarysearch;

public class FindInMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// order agnostic binary search
		
		// find peak element
		// binary search in ascending array part of the initial array
		// if not found,
		//		binary search in descending part of initial array
		
		int[] arr= {1,2,3,4,5,6,7,6,3,2};
		int peakIndex = peakInMountainArray(arr);
		
		//search in first half
		int indexInAscHalf = orderAgnosticBS(arr, 3, 0, peakIndex);
		if(indexInAscHalf!=-1) {
//			return indexInAscHalf;
			System.out.println(indexInAscHalf);
		}
		else {
			int indexInDescHalf = orderAgnosticBS(arr, 3, peakIndex, arr.length-1);
//			return indexInDescHalf;
			System.out.println(indexInDescHalf);
		}

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
	
	private static int orderAgnosticBS(int[] arr, int target, int start, int end) {
		
		// find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];
        
        while(start<=end) {
        	int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
        
	}
       

}
