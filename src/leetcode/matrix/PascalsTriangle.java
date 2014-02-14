package leetcode.matrix;

import java.util.ArrayList;

/*
 * Pascal's Triangle 
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * 
 * http://oj.leetcode.com/problems/pascals-triangle/
 * 
 * Hint: 
 * [1,3,3,1],
 * [1,4,6,4,1]   4=1+3 6=3+3 4=3+1
 */
public class PascalsTriangle {
	public class Solution {
	    public ArrayList<ArrayList<Integer>> generate(int numRows) {
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        for(int i=0;i<numRows;i++){
	            ArrayList<Integer> tmp=new ArrayList<Integer>();
	            tmp.add(1);
	            if(i>0){
	                for(int j=0;j<res.get(i-1).size()-1;j++)
	                    tmp.add(res.get(i-1).get(j)+res.get(i-1).get(j+1));
	                tmp.add(1);
	            }
	            res.add(tmp);
	        }
	        return res;
	    }
	}
}
