package leetcode.array;
/*
 * Maximum Subarray 
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * http://oj.leetcode.com/problems/maximum-subarray/
 * 
 * Hint: Greedy algorithm. If the subarray last at i is less than 0, it is not the answer. 
 * Also we need to compare subarrray that starts at i
 */
public class MaximumSubarray {
	public class Solution {
		public int maxSubArray(int[] A) {
		    int maxnow = 0;
		    int maxall = A[0];
		    for(int i=0;i<A.length;i++){
		        maxnow=Math.max(0,maxnow+A[i]);
		        if(maxnow>0){
		            maxall=Math.max(maxall,maxnow);
		        }else{
		            maxall=Math.max(maxall,A[i]);
		        }
		    }
		    return maxall;
		}
	}
}
