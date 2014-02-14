package leetcode.matrix;

/*
 * Unique Paths II 
 * 
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 * 
 * http://oj.leetcode.com/problems/unique-paths-ii/
 * 
 * Hint: Same as uniquepaths. The only difference is when obstacleGrid[i][j]==1
 */
public class UniquePathsII {
	public class Solution {
		public int uniquePathsWithObstacles(int[][] obstacleGrid) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			int m = obstacleGrid.length;
			int n = obstacleGrid[0].length;
			if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1)
				return 0;
			int[] tmp = new int[n];
			tmp[n - 1] = 1;
			for (int i = m - 1; i > -1; i--) {
				if (obstacleGrid[i][n - 1] == 1)
					tmp[n - 1] = 0;
				for (int j = n - 2; j > -1; j--) {
					if (obstacleGrid[i][j] == 1)
						tmp[j] = 0;
					else
						tmp[j] += tmp[j + 1];
				}
			}
			return tmp[0];
		}
	}
}
