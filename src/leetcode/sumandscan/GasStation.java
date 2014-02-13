package leetcode.sumandscan;
/*
 * Gas Station
 * 
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 * 
 * http://oj.leetcode.com/problems/gas-station/
 * 
 * Hint: First, if the total sum of gas minus sum of costs is smaller than 0, there is no solution.
 * Second, set start to be the end of the circle route(-1 means the end is the last station). 
 * Since "The solution is guaranteed to be unique",
 * if sum is less than 0, then index "i" can only be the end of the circle route.
 * If it happens, set starIndex to record the index and reset sum=0.
 */
public class GasStation {
	public class Solution {
		public int canCompleteCircuit(int[] gas, int[] cost) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int n = gas.length, start = -1;
	        int sum = 0, total = 0;
	        for(int i = 0; i < n; i++){
	            sum += (gas[i] - cost[i]);
	            total += (gas[i] - cost[i]);
	            if(sum < 0){
	                start = i; 
	                sum = 0;
	            }
	        }
	        return total >= 0 ? start + 1 : -1;
	    }
	}
}
