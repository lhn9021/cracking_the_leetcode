package leetcode.matrix;

import java.util.ArrayList;

/*
 * Pascal's Triangle II 
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * http://oj.leetcode.com/problems/pascals-triangle-ii/
 * 
 * Hint: Except 1, res[i]=res[i]+res[i-1]
 */
public class PascalsTriangleII {
	public class Solution {
	    public ArrayList<Integer> getRow(int rowIndex) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int []res = new int[rowIndex+1];
	        res[0]=1;
	        if(rowIndex==0) return getList(res);
	        for(int j=1;j<rowIndex+1;j++){
	            for(int i=j-1;i>0;i--){
	                res[i]=res[i]+res[i-1];
	            }
	            res[j]=1;
	        }
	        return getList(res);
	    }
	    
	    public ArrayList<Integer> getList(int[] nums){
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        for(int i=0;i<nums.length;i++){
	            res.add(nums[i]);
	        }
	        return res;
	    }
	}
}
