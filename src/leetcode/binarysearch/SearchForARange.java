package leetcode.binarysearch;

/*
 * Search for a Range 
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * http://oj.leetcode.com/problems/search-for-a-range/
 * 
 * Hint: Use search for insert position
 */
public class SearchForARange {
	public class Solution {
		public int[] searchRange(int[] A, int target) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			int[] res = new int[2];
			res[0] = bs(A, target - 1) + 1;
			res[1] = bs(A, target);
			if (res[1] == -1 || A[res[1]] != target) {
				res[0] = -1;
				res[1] = -1;
			}
			return res;

		}

		public int bs(int[] A, int target) {
			int start = 0, end = A.length - 1, mid = start + (end - start) / 2;
			int ret = -1;
			while (start <= end) {
				mid = start + (end - start) / 2;
				if (A[mid] > target)
					end = mid - 1;
				else {
					ret = mid;
					start = mid + 1;
				}
			}
			return ret;
		}

	}
}
