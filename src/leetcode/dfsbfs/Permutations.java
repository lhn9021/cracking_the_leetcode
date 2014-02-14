package leetcode.dfsbfs;

import java.util.ArrayList;

/*
 * Permutations
 * 
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * http://oj.leetcode.com/problems/permutations/
 * 
 * Hint: You can use dfs or you can use swap
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 */
public class Permutations {
	public class Solution {
	    public ArrayList<ArrayList<Integer>> permute(int[] num) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> tmp=new ArrayList<Integer>();
	        int n=num.length;
	        boolean[] visited=new boolean[n];
	        permute(res,tmp,num,visited);
	        return res;
	    }
	    public void permute(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> tmp, int []num,boolean[]visited){
	        if(tmp.size()==num.length){
	            res.add(new ArrayList<Integer>(tmp));
	            return;
	        }
	        for(int i=0;i<num.length;i++){
	            if(!visited[i]){
	                visited[i]=true;
	                tmp.add(num[i]);
	                permute(res,tmp,num,visited);
	                visited[i]=false;
	                tmp.remove(tmp.size()-1);
	            }
	        }
	        
	    }
	}
}
