package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Subsets 
 * 
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 * http://oj.leetcode.com/problems/subsets/
 * 
 * Hint: Standard dfs. Notice add res before dfs.
 */
public class Subsets {
	public class Solution {
	    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
	        Arrays.sort(S);
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> tmp = new ArrayList<Integer>();
	        res.add(new ArrayList<Integer>());
	        dfs(0, S, tmp, res);
	        return res;
	    }
	    public void dfs(int index, int[] num, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> res){
	        for(int i = index; i < num.length; i++){
	            tmp.add(num[i]);
	            //save result and then dfs
	            res.add(new ArrayList<Integer>(tmp));
	            dfs(i + 1, num, tmp, res);
	            tmp.remove(tmp.size() - 1);
	            // while(i < num.length - 1 && num[i+1] == num[i])
	            //     i++;
	        }
	    }
	}
}
