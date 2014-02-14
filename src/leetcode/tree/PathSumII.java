package leetcode.tree;

import java.util.ArrayList;

/*
 * Path Sum II
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * http://oj.leetcode.com/problems/path-sum-ii/
 * 
 * Hint: DFS
 */
public class PathSumII {
	public class Solution {
		public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> path = new ArrayList<Integer>();
			path(root, sum, res, path);
			return res;
		}

		public void path(TreeNode root, int sum,
				ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path) {
			if (root == null)
				return;
			int rest = sum - root.val;
			path.add(root.val);
			if (rest == 0 && root.left == null && root.right == null) {
				ArrayList<Integer> p = new ArrayList<Integer>(path);
				res.add(p);
			} else {
				path(root.left, rest, res, path);
				path(root.right, rest, res, path);
			}
			path.remove(path.size() - 1);
		}
	}
}
