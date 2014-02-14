package leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Combination Sum II 
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * 
 * http://oj.leetcode.com/problems/combination-sum-ii/
 * 
 * Hint: Same as combinationsum. The only difference is marked
 */
public class CombinationSumII {
	public class Solution {
	    public ArrayList<ArrayList<Integer>> res;
	    public ArrayList<Integer> tmp;

	    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
	        res = new ArrayList<ArrayList<Integer>>();
	        tmp = new ArrayList<Integer>();
	        Arrays.sort(candidates);
	        recur(candidates, target, 0);
	        return res;
	    }

	    public void recur(int[] candidates, int target, int index) {
	        if(target == 0) {
	            res.add(new ArrayList<Integer>(tmp));
	        }else if(index == candidates.length || candidates[index] > target) {
	            return;
	        }else{
	            for(int i = index; i < candidates.length; i++) {
	                if(candidates[i] <= target) {
	                    tmp.add(candidates[i]);
	                    recur(candidates, target - candidates[i], i + 1);
	                    tmp.remove(tmp.size() - 1);
	                    //skip duplicates
	                    while(i < candidates.length - 1 && candidates[i + 1] == candidates[i]) i++;
	                }
	            } 
	        }
	    }
	}
}
