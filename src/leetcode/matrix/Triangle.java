package leetcode.matrix;

import java.util.ArrayList;

/*
 * Triangle 
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * 
 * http://oj.leetcode.com/problems/triangle/
 * 
 * Hint: start from the 2nd row from the end and choose the smaller value in the next row.
 */
public class Triangle {
	public class Solution {
		public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			if (triangle.size() == 0)
				return -1;
			if (triangle.size() == 1)
				return triangle.get(0).get(0);
			int size = triangle.size();
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.addAll(triangle.get(triangle.size() - 1));
			for (int i = size - 2; i >= 0; i--) {
				for (int j = 0; j < triangle.get(i).size(); j++) {
					list.set(j,triangle.get(i).get(j)+ Math.min(list.get(j), list.get(j + 1)));
				}
			}
			return list.get(0);
		}
	}
}
