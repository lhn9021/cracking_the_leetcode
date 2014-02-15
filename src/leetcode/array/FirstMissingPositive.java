package leetcode.array;
/*
 * First Missing Positive 
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * http://oj.leetcode.com/problems/first-missing-positive/
 * 
 * Hint: swap the array so that A[i]=A[i]-1 and find the first one that A[i]!=i+1
 */
public class FirstMissingPositive {
	public class Solution {
	    public int firstMissingPositive(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        for(int i=0;i<A.length;i++){
	            while(i!=A[i]-1){
	                // situation that cannot swap
	                if(A[i]<=0||A[i]>A.length||A[i]==A[A[i]-1]) break;
	                else{
	                    int tmp=A[A[i]-1];
	                    A[A[i]-1]=A[i];
	                    A[i]=tmp;
	                }
	            }
	        }
	        
	        for(int i=0;i<A.length;i++){
	            if(A[i]!=i+1) return i+1;
	        }
	        return A.length+1;
	    }
	}
}
