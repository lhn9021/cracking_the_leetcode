package leetcode.binarysearch;
/*
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * 
 * Hint: the only difference is that if A[l]=A[r] we don't know where target could be.
 * The solution is search target in both parts.
 */
public class searchInRotatedSortedArrayII {
	public class Solution {
		public boolean search(int[] A, int l, int r, int target) {
			while (l <= r) {
				int mid = l + (r - l) / 2;
				if (A[mid] == target)
					return true;
				if (A[l] == A[r]) {
					return search(A, l, mid - 1, target)|| search(A, mid + 1, r, target);
				}
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
			return false;

		}
		public boolean search(int[] A, int target) {
			return search(A, 0, A.length - 1, target);
		}
	}
}
