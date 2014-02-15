package leetcode.array;
/*
 * Remove Element 
 * 
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * http://oj.leetcode.com/problems/remove-element/
 */
public class RemoveElement {
	public class Solution {
	    public int removeElement(int[] A, int elem) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int index=0;
	        for(int i=0;i<A.length;i++){
	            if(A[i]==elem) continue;
	            else{
	                A[index++]=A[i];
	            }
	        }
	        return index;
	    }
	}
}
