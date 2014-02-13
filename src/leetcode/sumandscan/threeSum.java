package leetcode.sumandscan;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * 
 * http://oj.leetcode.com/problems/3sum/
 * 
 * Hint: Sort the array first;
 * The first loop will iterate every c such that -c = a+b and skip duplicate c;
 * Then scan from head and tail to find possible solutions which also skip duplicate results;
 * Since the array is sorted, num[l]<=num[r].If num[l] + num[r] < -num[i], we need advance head to search num[l] + num[r] == -num[i],
 * vice versa.
 */
public class threeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		if (num == null || num.length < 3)
			return res;
		for (int i = 0; i < num.length; i++) {
			// prohibit duplicate c
			if (i == 0 || num[i] != num[i - 1]) {
				int l = i + 1, r = num.length - 1;
				while (l < r) {
					if (num[l] + num[r] == -num[i]) {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(num[i]);
						tmp.add(num[l]);
						tmp.add(num[r]);
						res.add(tmp);
						l++;
						r--;
						//prohibit duplicate a and b
						while (l < r && num[l] == num[l - 1])
							l++;
						while (l < r && num[r] == num[r + 1])
							r--;
					} else if (num[l] + num[r] < -num[i]) {
						l++;
					} else {
						r--;
					}
				}
			}
		}
		return res;
	}
}
