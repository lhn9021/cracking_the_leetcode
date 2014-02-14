package leetcode.matrix;

import java.util.ArrayList;

/*
 * Spiral Matrix
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * http://oj.leetcode.com/problems/spiral-matrix/
 * 
 * Hint: the matrix may not be n * n
 */
public class SpiralMatrix {
	public class Solution {
	    public ArrayList<Integer> spiralOrder(int[][] matrix) {
	        ArrayList<Integer> order = new ArrayList<Integer>(); 
	        if (matrix.length == 0 || matrix[0].length == 0) return order;
	        int xMin = 0;
	        int yMin = 0;
	        int xMax = matrix[0].length - 1;
	        int yMax = matrix.length - 1;
	        int i = -1, j = 0;
	        while(true){
	            while(i<xMax) order.add(matrix[j][++i]);
	            if(++yMin>yMax) break;
	            while(j<yMax) order.add(matrix[++j][i]);
	            if(xMin>--xMax) break;
	            while(i>xMin) order.add(matrix[j][--i]);
	            if(yMin>--yMax) break;
	            while(j>yMin) order.add(matrix[--j][i]);
	            if(++xMin>xMax) break;
	        }
	        return order;
	    }
	}
}
