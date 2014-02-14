package leetcode.matrix;

/*
 * Rotate Image
 * 
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 * 
 * http://oj.leetcode.com/problems/rotate-image/
 * 
 * Hint: Draw a matrix can help you understand this.
 */
public class RotateImage {
	public class Solution {
		public void rotate(int[][] matrix) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			int start = 0;
			int end = matrix.length - 1;
			while (start < end) {
				for (int i = start; i < end; i++) {
					int offset = i - start;
					int top = matrix[start][i];
					matrix[start][i] = matrix[end - offset][start];
					matrix[end - offset][start] = matrix[end][end - offset];
					matrix[end][end - offset] = matrix[i][end];
					matrix[i][end] = top;
				}
				start++;
				end--;
			}
		}
	}
}
