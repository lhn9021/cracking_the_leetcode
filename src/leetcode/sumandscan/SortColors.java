package leetcode.sumandscan;

/*
 * Sort Colors
 * 
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 *  with the colors in the order red, white and blue.
 *  Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *  
 *  http://oj.leetcode.com/problems/sort-colors/
 *  
 *  Hint: store 0 in left, 2 in right
 *  When A[index]==2, swap the A[right] and A[index] and right-- if after swap, A[index]==2, keep swapping
 *  When A[index]==0, swap the A[left] and A[index] and left++.After swap, A[index] cannot be 2, so index++;
 *  then * ahead left should be 0, * behind right should be 2
 *  When A[index]==1 index++;
 */
public class SortColors {
	public class Solution {
		public void sortColors(int[] A) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			int l = 0;
			int r = A.length - 1;
			int index = 0;
			while (index <= r) {
				if (A[index] == 2) {
					int tmp = A[r];
					A[r] = A[index];
					A[index] = tmp;
					r--;
				} else if (A[index] == 0) {
					int tmp = A[l];
					A[l] = A[index];
					A[index] = tmp;
					l++;
					index++;
				} else {
					index++;
				}

			}
		}
	}
}
