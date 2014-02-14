package leetcode.dfsbfs;

import java.util.ArrayList;

/*
 * Combinations
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 
 * http://oj.leetcode.com/problems/combinations/
 * 
 * Hint: standard dfs
 */
public class Combinations {
	public class Solution {
	    ArrayList<ArrayList<Integer>> res=null;
	    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	        res =new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> tmp = new ArrayList<Integer>();
	        dfs(n, k, 1, tmp);
	        return res;
	    }
	    
	    public void dfs(int n, int k, int pos, ArrayList<Integer> tmp){
	        if(tmp.size() == k){
	            res.add(new ArrayList<Integer>(tmp));
	            return;
	        }
	        for(int i=pos; i<=n; i++){
	            tmp.add(i);
	            dfs(n, k, i+1, tmp);
	            tmp.remove(tmp.size()-1);
	        }
	    }
	}
}
