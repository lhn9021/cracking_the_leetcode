package leetcode.array;

import java.util.HashMap;

/*
 * Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * 
 * http://oj.leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Hint: Merge the consecutive part and update the new range.
 */
public class LongestConsecutiveSequence {
	public class Solution {
	    public int longestConsecutive(int[] num) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	        int max=1;
	        for(int number: num){
	            if(map.containsKey(number)) continue;
	            map.put(number,1);
	            if(map.containsKey(number-1)){
	                max=Math.max(max,merge(map,number-1,number));
	                
	            }
	            if(map.containsKey(number+1)){
	                max=Math.max(max,merge(map,number,number+1));
	            }
	        }
	        return max;
	    }
	    public int merge(HashMap<Integer,Integer>map,int left,int right){
	        int upper=right+map.get(right)-1;
	        int lower=left-map.get(left)+1;
	        int len=upper-lower+1;
	        map.put(upper,len);
	        map.put(lower,len);
	        return len;
	    }
	}
}
