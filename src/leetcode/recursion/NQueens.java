package leetcode.recursion;

import java.util.ArrayList;

/*
 * N-Queens
 * 
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * http://oj.leetcode.com/problems/n-queens/
 * 
 * Hint: use sol[] to check whether the position is taken or not.
 */
public class NQueens {
	public class Solution {
	    public ArrayList<String[]> solveNQueens(int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        ArrayList<String[]> res=new ArrayList<String[]>();
	        if(n<0) return res;
	        int[] tmp=new int[n];
	        placeQueen(tmp,0,res);
	        return res;
	    }
	    
	    public void placeQueen(int[] tmp,int row,ArrayList<String[]> res){
	    	int n=tmp.length;
	        if(row==n){
	            res.add(transform(tmp));
	            return;
	        }
	        for(int i=0;i<n;i++){
	            if(!isTaken(tmp,row,i)){
	                tmp[row]=i;
	                placeQueen(tmp,row+1,res);
	            }
	        }
	    }
	    public boolean isTaken(int[] tmp,int row,int col){
	        for(int i=0;i<row;i++){
	            if(tmp[i]==col||(Math.abs(col-tmp[i])==Math.abs(row-i))) return true;
	        }
	        return false;
	    }
	    public String[] transform(int[] sol){
		        int n = sol.length;
		        String[] res = new String[n];   
		        for (int i = 0; i < n; i++) {
		            StringBuilder sb = new StringBuilder();
		            for (int j = 0; j < n; j++) {
		                if (j == sol[i]) {
		                    sb.append("Q");
		                }
		                else {
		                    sb.append(".");
		                }
		            }
		            res[i] = sb.toString();
		        }
		        return res;
		    }
	    
	}
}
