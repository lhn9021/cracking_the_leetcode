package leetcode.sumandscan;

import java.util.Arrays;

/*
 * 3Sum Closest
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * http://oj.leetcode.com/problems/3sum-closest/
 * 
 * Hint: same as 3sum. The only diff is to update res when Math.abs(sum-target)<Math.abs(res-target)
 * Also there is no duplicates restriction
 */
public class ThreeSumClosest {
	public class Solution {
		public int threeSumClosest(int[] num, int target) {
			if (num.length < 3) {
				return Integer.MAX_VALUE;
			}
			Arrays.sort(num);
			int res = num[0] + num[1] + num[2];
			for (int i = 0; i < num.length - 2; ++i) {
				int l = i + 1, r = num.length - 1;
				while (l < r) {
					int sum = num[i] + num[l] + num[r];
					if (Math.abs(sum - target) < Math.abs(res - target))
						res = sum;
					if (sum == target)
						return target;
					else if (sum > target)
						r--;
					else
						l++;
				}
			}
			return res;
		}
	}
}
