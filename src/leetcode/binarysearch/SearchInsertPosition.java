package leetcode.binarysearch;
/*
 * Search Insert Position
 * 
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 * 
 * http://oj.leetcode.com/problems/search-insert-position/
 * 
 * Hint: Use binary search and record number which less or equal to target
 */
public class SearchInsertPosition {
	public class Solution {
	    public int searchInsert(int[] A, int target) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int start=0,end=A.length-1,mid=start+(end-start)/2;
	        int ret=-1;
	        while(start<=end){
	            mid=start+(end-start)/2;
	            if(A[mid]>target) end=mid-1;
	            else{
	                ret=mid;
	                start=mid+1;
	            }
	        }
	        if(ret!=-1&&A[ret]==target) return ret;
	        else return ret+1;
	    }
	}
}
