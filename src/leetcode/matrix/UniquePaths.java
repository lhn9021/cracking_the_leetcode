package leetcode.matrix;

/*
 * Unique Paths 
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * 
 * http://oj.leetcode.com/problems/unique-paths/
 * 
 * Hint: From end to start, matrix[m][n]=matrix[m+1][n]+ matrix[m][n+1]
 */
public class UniquePaths {
	public class Solution {
		public int uniquePaths(int m, int n) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			int[] tmp = new int[n];
			tmp[n - 1] = 1;
			for (int i = 0; i < m; i++) {
				for (int j = n - 2; j > -1; j--) {
					tmp[j] += tmp[j + 1];
				}
			}
			return tmp[0];
		}
	}
}
