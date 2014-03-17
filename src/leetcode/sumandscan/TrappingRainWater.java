package leetcode.sumandscan;
/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * http://oj.leetcode.com/problems/trapping-rain-water/
 * 
 * Hint: 
 */
public class TrappingRainWater {
	public class Solution {
	    public int trap(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int n=A.length;
	        if(n==0) return 0;
	        int i=0,j=n-1,lm=A[0],rm=A[n-1],sum=0;
	        while(i<j){
	            if(lm<rm){
	                if(A[++i]<lm) sum+=lm-A[i];
	                else lm=A[i];
	            }else{
	                if(A[--j]<rm) sum+=rm-A[j];
	                else rm=A[j];
	            }
	        }
	        return sum;
	    }
	}
}
