package leetcode.array;
/*
 * Remove Duplicates from Sorted Array 
 * 
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * 
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * 
 */
public class RemoveDuplicatesFromSortedArray {
	public class Solution {
	    public int removeDuplicates(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(A.length==0||A.length==1) return A.length;
	        int index=0;
	        for(int i=1;i<A.length;i++){
	            if(A[i]==A[index]) continue;
	            else A[++index]=A[i];
	        }
	        return index+1;
	    }
	}
}
