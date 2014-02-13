package leetcode.binarysearch;
/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * http://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * Hint: dividet the array into two parts, then definitely one part is sorted and one part is rotated.
 * We can look at sorted part first , if it is not there then we have to search the rotated part;
 * For example: if A[l] <= A[mid], the left part is not rotated vice versa
 * If A[l]<=target<A[mid], since this part is sorted, we can use binary search to find target for sure. If not, find target fromA[mid+1] to A[r]. Vice versa.
 */
public class SearchInRoratedSortedArray {
	public class Solution {
		public int search(int[] A, int target) {
			int l = 0;
			int r = A.length - 1;
			while (l <= r) {
				int mid = l + (r - l) / 2;
				if (A[mid] == target)
					return mid;
				if (A[l] <= A[mid]) {
					if (target >= A[l] && target < A[mid])
						r = mid - 1;
					else
						l = mid + 1;
				} else {
					if (target > A[mid] && target <= A[r])
						l = mid + 1;
					else
						r = mid - 1;
				}
			}
			return -1;
		}
	}
}
