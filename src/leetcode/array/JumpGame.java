package leetcode.array;
/*
 * Jump Game 
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * http://oj.leetcode.com/problems/jump-game/
 * 
 * Hint: If i is larger than next step's range, return false.
 */
public class JumpGame {
	public class Solution {
	    public boolean canJump(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int nextMax=0;
	        for(int i=0;i<A.length;i++){
	            if(i>nextMax) return false;
	            else{
	                nextMax=Math.max(nextMax,i+A[i]);
	            }
	        }
	        return true;
	    }
	}
}
