package leetcode.dp;
/*
 * Minimum Path Sum
 * 
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 
 * http://oj.leetcode.com/problems/minimum-path-sum/
 * 
 * Hint: find the minimum of left or top
 */
public class MinimumPathSum {
	public class Solution {
	    public int minPathSum(int[][] grid) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int[][]map=new int[grid.length][grid[0].length];
	        map[0][0]=grid[0][0];
	        for(int i=1;i<grid[0].length;i++){
	            map[0][i]=grid[0][i]+map[0][i-1];
	        }
	        for(int i=1;i<grid.length;i++){
	            map[i][0]=grid[i][0]+map[i-1][0];
	        }
	        for(int i=1;i<grid.length;i++){
	            for(int j=1;j<grid[0].length;j++){
	                map[i][j]=Math.min(map[i-1][j],map[i][j-1])+grid[i][j];
	            }
	        }
	        return map[grid.length-1][grid[0].length-1];
	    }
	}
}
