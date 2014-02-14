package leetcode.matrix;
/*
 * Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * 
 * http://oj.leetcode.com/problems/search-a-2d-matrix/
 * 
 * Hint: start search from the top right. If the matrix value is smaller than target, row++, else col--
 */
public class SearchA2DMatrix {
	public class Solution {
	    public boolean searchMatrix(int[][] matrix, int target) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int row=matrix.length;
	        int col=matrix[0].length;
	        int i=0,j=col-1;
	        while(i<row&&j>-1){
	            if(matrix[i][j]==target) return true;
	            else if(matrix[i][j]>target) j--;
	            else i++;
	        }
	        return false;
	    }
	}
}
