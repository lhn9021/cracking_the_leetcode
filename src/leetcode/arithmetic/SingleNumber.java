package leetcode.arithmetic;
/*
 * Single Number 
 * 
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * http://oj.leetcode.com/problems/single-number/
 * 
 * Hint: A^A=0 0^A=A
 */
public class SingleNumber {
	public class Solution {
	    public int singleNumber(int[] A) {
	        int result=0;
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        for(int i=0;i<A.length;i++){
	            result=result^A[i];
	        }
	        return result;
	    }
	}
}
