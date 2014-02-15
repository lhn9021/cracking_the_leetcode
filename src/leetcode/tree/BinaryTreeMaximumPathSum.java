package leetcode.tree;

import java.util.ArrayList;

/*
 * Binary Tree Maximum Path Sum
 * 
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * 
 * http://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 * Hint: Use maxSum to find the max which could cross the node. Use getMaxSum to get the maximum of path sum begin at that node. 
 */
public class BinaryTreeMaximumPathSum {
	public class Solution {
		public int maxPathSum(TreeNode root) {
			ArrayList<Integer> maxSum = new ArrayList<Integer>(1);
			maxSum.add(Integer.MIN_VALUE);
			getMaxSum(root, maxSum);
			return maxSum.get(0);
		}

		public int getMaxSum(TreeNode root, ArrayList<Integer> maxSum) {
			if (root == null) {
				return 0;
			}
			int leftSum = getMaxSum(root.left, maxSum);
			int rightSum = getMaxSum(root.right, maxSum);
			int curSum = Math.max(root.val,
					Math.max(root.val + leftSum, root.val + rightSum));
			maxSum.add(0,Math.max(maxSum.get(0),Math.max(curSum, root.val + leftSum + rightSum)));
			return curSum;
		}
	}
}
