package leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Combination Sum 
 * 
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * 
 * http://oj.leetcode.com/problems/combination-sum/
 * 
 * Hint: first sort the array and then recursion.
 */
public class CombinationSum {
	public class Solution {
	    public  ArrayList<ArrayList<Integer>> res;
	    public  ArrayList<Integer> tmp;
	    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	        res = new ArrayList<ArrayList<Integer>>();
	        tmp = new ArrayList<Integer>();
	        Arrays.sort(candidates);
	        recur(candidates, target, 0);
	        return res;
	    }
	    public void recur(int[] candidates, int target, int index) {
	        if(target==0){
	            res.add(new ArrayList<Integer> (tmp));
	            return;
	        }else if(index == candidates.length||candidates[index]>target){
	            return;
	        }else{
	            for(int i=index;i<candidates.length;i++){
	                if(candidates[i]<=target){
	                    tmp.add(candidates[i]);
	                    recur(candidates,target-candidates[i],i);
	                    tmp.remove(tmp.size()-1);
	                }
	            }
	        }
	        
	    }
	}
}
