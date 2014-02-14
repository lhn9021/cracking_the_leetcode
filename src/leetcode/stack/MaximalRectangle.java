package leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/*
 * Maximal Rectangle 
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 * 
 * http://oj.leetcode.com/problems/maximal-rectangle/
 * 
 * Hint: Use largest rectangle in histogram.
 */
public class MaximalRectangle {
	public class Solution {
		public int maximalRectangle(char[][] matrix) {
			// Start typing your Java solution below
			// DO NOT write main() function
			if (matrix.length == 0) {
				return 0;
			}
			int m = matrix.length, n = matrix[0].length, max = 0;
			int[] heights = new int[n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] == '1')
						heights[j]++;
					else
						heights[j] = 0;
				}
				max = Math.max(max, largestRectangleArea(heights));
			}

			return max;
		}

		public int largestRectangleArea(int[] height) {
			Stack<Integer> stack = new Stack<Integer>();
			int i = 0;
			int maxArea = 0;
			int[] h = new int[height.length + 1];
			h = Arrays.copyOf(height, height.length + 1);
			while (i < h.length) {
				if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
					stack.push(i++);
				} else {
					int t = stack.pop();
					maxArea = Math.max(maxArea, h[t]
							* (stack.isEmpty() ? i : i - stack.peek() - 1));
				}
			}
			return maxArea;
		}
	}
}
