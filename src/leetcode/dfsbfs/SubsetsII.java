package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Subsets II
 * 
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * 
 * http://oj.leetcode.com/problems/subsets-ii/
 * 
 * Hint: Same as subset. Avoid duplicates.
 */
public class SubsetsII {
	public class Solution {
		public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		    // Start typing your Java solution below
		    // DO NOT write main() function
		    Arrays.sort(num);
		    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		    ArrayList<Integer> sub = new ArrayList<Integer>();
		    res.add(new ArrayList<Integer>());
		    subsetsIIHelper(0, num, sub, res);
		    return res;
		}
		public void subsetsIIHelper(int index, int[] num, ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> res){
		    for(int i = index; i < num.length; i++){
		        sub.add(num[i]);
		        res.add(new ArrayList<Integer>(sub));
		        subsetsIIHelper(i + 1, num, sub, res);
		        sub.remove(sub.size() - 1);
		        //avoid duplicates
		        while(i < num.length - 1 && num[i+1] == num[i])
		            i++;
		    }
		}
		}
}
