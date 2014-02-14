package leetcode.recursion;
/*
 * N-Queens II
 * 
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 * http://oj.leetcode.com/problems/n-queens-ii/
 * 
 * Hint: same as n queens i
 */
public class NQueensII {
	public class Solution {
	    public int totalNQueens(int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int[] count = new int[1];
	        if (n <= 0) {
	            return 0;
	        }
	        int[] tmp = new int[n]; //the i-th element is the column number of the queen in the i-th row
	        placeQueen(tmp, 0, count);
	        return count[0];
	    }
	    public void placeQueen(int[] tmp, int row, int[] count) {
	        int n = tmp.length;
	        if (row == n) {
	            count[0]++;
	            return;
	        }
	        for (int i = 0; i < n; i++) {
	            if (!isTaken(tmp, row, i)) {
	                tmp[row] = i;
	                placeQueen(tmp, row+1, count);
	            }
	        }
	    }
	 
	    public boolean isTaken(int[] tmp, int row, int col) {
	    	for(int i=0;i<row;i++){
	            if(tmp[i]==col||(Math.abs(col-tmp[i])==Math.abs(row-i))) return true;
	        }
	        return false;
	    }
	}
}
