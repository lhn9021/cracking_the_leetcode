package leetcode.matrix;

/*
 * Set Matrix Zeroes 
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 * http://oj.leetcode.com/problems/set-matrix-zeroes/
 * 
 * Hint: use two boolean variable to store whether 1st row and 1st col has 0. 
 * Then scan all the image and set matrix[row][0] matrix[0][col] to 0
 * Set the responding col row to 0
 * Finally check whether 1st row 1st col should be 0
 */
public class SetMatrixZeroes {
	public class Solution {
		public void setZeroes(int[][] matrix) {

			boolean firstRow = false, firstColumn = false;
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[i][0] == 0) {
					firstColumn = true;
					break;
				}
			}

			for (int i = 0; i < matrix[0].length; i++) {
				if (matrix[0][i] == 0) {
					firstRow = true;
					break;
				}
			}

			for (int i = 1; i < matrix.length; i++) {
				for (int j = 1; j < matrix[0].length; j++) {
					if (matrix[i][j] == 0) {
						matrix[i][0] = 0;
						matrix[0][j] = 0;
					}
				}
			}

			for (int i = 1; i < matrix.length; i++) {
				for (int j = 1; j < matrix[0].length; j++) {
					if (matrix[i][0] == 0 || matrix[0][j] == 0) {
						matrix[i][j] = 0;
					}
				}
			}

			if (firstRow) {
				for (int i = 0; i < matrix[0].length; i++)
					matrix[0][i] = 0;
			}

			if (firstColumn) {
				for (int i = 0; i < matrix.length; i++)
					matrix[i][0] = 0;
			}

		}
	}
}
