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
 * Hint: Greedy algorithm. If the subarray ends at i is less than 0, it will reduce the sum for next numbers. It is not the answer. 
 * Also we need to compare subarrray that starts at i
 */
public class MaximumSubarray {
//	public class Solution {
//		public int maxSubArray(int[] A) {
//		    int maxnow = 0;
//		    int maxall = A[0];
//		    for(int i=0;i<A.length;i++){
//		        maxnow=Math.max(0,maxnow+A[i]);
//		        if(maxnow>0){
//		            maxall=Math.max(maxall,maxnow);
//		        }else{
//		            maxall=Math.max(maxall,A[i]);
//		        }
//		    }
//		    return maxall;
//		}
//	}
	//when currentSum is negative, currentSum+A[i]<A[i], so we start a new beginning same as greedy
	//when currentSum is positive, currentSum+A[i]>A[i] so we add A[i]
	 public int maxSubArray(int[] A) {
	        int currentSum=A[0],maxSum=A[0];
	        for(int i=1;i<A.length;i++){
	            currentSum=Math.max(currentSum+A[i],A[i]);
	            maxSum=Math.max(maxSum,currentSum);
	        }
	        return maxSum;
	    }
}
