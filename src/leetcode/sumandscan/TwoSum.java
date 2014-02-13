package leetcode.sumandscan;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * http://oj.leetcode.com/problems/two-sum/
 * 
 * Hint: (Special case)use hashmap to store the index. O(n)
 */
public class TwoSum {
	public class Solution {
		public int[] twoSum(int[] numbers, int target) {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int[] res = new int[2];
			for (int i = 0; i < numbers.length; i++) {
				if (map.containsKey(numbers[i])) {
					res[0] = map.get(numbers[i]);
					res[1] = i + 1;
					return res;
				} else {
					map.put(target - numbers[i], i + 1);
				}
			}
			return null;
		}
	}
}
