package leetcode.array;
/*
 * Jump Game II
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * 
 * http://oj.leetcode.com/problems/jump-game-ii/
 * 
 * Hint: curmax stands for current step's max range. nextmax stands for next step's max range.
 * If i > next step's max range, which is not possible return -1;
 */
public class JumpGameII {
	public class Solution {
		public int jump(int[] A) {
		    int curMax=0;
		    int nextMax=0;
		    int step=0;
		    for(int i=0;i<A.length;i++){
		        if(i>nextMax) return -1;
		        if(i>curMax){
		            step++;
		            curMax=nextMax;
		        }
		        nextMax=Math.max(nextMax,A[i]+i);
		    }
		    return step;
		}
		}
}
