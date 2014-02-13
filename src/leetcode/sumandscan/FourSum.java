package leetcode.sumandscan;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 4Sum
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 * 
 * http://oj.leetcode.com/problems/4sum/
 * 
 * Hint: same as 3sum. In this case, we have to first select two fixed numbers and scan from head and tail
 * Also we need to avoid duplicates as before.
 */
public class FourSum {
	public class Solution {
		public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
			Arrays.sort(num);
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			//fix 1st number
			for (int i = 0; i < num.length; i++) {
				if (i == 0 || num[i] != num[i - 1])
					//fix 2nd number
					for (int j = i + 1; j < num.length; j++) {
						if (j == i + 1 || num[j] != num[j - 1]) {
							int l = j + 1, r = num.length - 1;
							//scan from head and tail
							while (l < r) {
								int sum = num[i] + num[j] + num[l] + num[r];
								if (sum == target) {
									ArrayList<Integer> tmp = new ArrayList<Integer>();
									tmp.add(num[i]);
									tmp.add(num[j]);
									tmp.add(num[l]);
									tmp.add(num[r]);
									result.add(tmp);
									r--;
									l++;
									while (l < r && num[l] == num[l - 1])
										l++;
									while (l < r && num[r] == num[r + 1])
										r--;
								} else if (sum > target) {
									r--;
								} else {
									l++;
								}
							}
						}
					}
			}
			return result;
		}
	}
}
