package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Permutations II
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 * http://oj.leetcode.com/problems/permutations-ii/
 * 
 * Hint: same as permutations. Be careful about duplicates
 */
public class PermutationsII {
	public class Solution {
	    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {   
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
	        ArrayList<Integer> tmp = new ArrayList<Integer>(); 
	        Arrays.sort(num);
	        int n = num.length;  
	        boolean[] visited = new boolean[n];  
	          
	        permuteImp(res, tmp, num, visited);  
	          
	        return res;  
	    }
	    private void permuteImp(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] num, boolean[] visited){  
	        if(tmp.size() == num.length){  
	            res.add(new ArrayList<Integer>(tmp));  
	            return;  
	        }  
	        for(int i=0; i<num.length; i++){  
	            if(!visited[i]){  
	                tmp.add(num[i]);  
	                visited[i] = true;  
	                permuteImp(res, tmp, num, visited);  
	                visited[i] = false;  
	                tmp.remove(tmp.size()-1);  
	                //avoid duplicates
	                while(i+1<num.length&&num[i]==num[i+1]) i++;
	            }  
	        }  
	    }  
}
}
