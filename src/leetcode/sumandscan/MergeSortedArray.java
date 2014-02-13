package leetcode.sumandscan;

/*
 * Median of Two Sorted Arrays 
 * 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * 
 * http://oj.leetcode.com/problems/merge-sorted-array/
 * 
 * Hint: scan from the end and compare
 *
 */
public class MergeSortedArray {
	public class Solution {
		public void merge(int A[], int m, int B[], int n) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			int k = m + n - 1;
			while (m > 0 && n > 0) {
				if (A[m - 1] > B[n - 1]) {
					A[k] = A[m - 1];
					m--;
				} else {
					A[k] = B[n - 1];
					n--;
				}
				k--;
			}
			//since a has enough space, we only need to take care of b if b hasn't finished.
			while (n > 0) {
				A[k] = B[n - 1];
				n--;
				k--;
			}
		}
	}
}
