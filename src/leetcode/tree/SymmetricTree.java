package leetcode.tree;

/*
 * Symmetric Tree 
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * http://oj.leetcode.com/problems/symmetric-tree/
 * 
 * Hint: same structure as same tree
 */
public class SymmetricTree {
	public class Solution {
		public boolean isSymmetric(TreeNode root) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			if (root == null)
				return true;
			return isSymmetric(root.left, root.right);
		}

		public boolean isSymmetric(TreeNode left, TreeNode right) {
			if (left == null)
				return right == null;
			if (right == null)
				return false;
			if (left.val != right.val)
				return false;
			if (!isSymmetric(left.left, right.right)|| !isSymmetric(left.right, right.left))
				return false;
			return true;
		}
	}
}
