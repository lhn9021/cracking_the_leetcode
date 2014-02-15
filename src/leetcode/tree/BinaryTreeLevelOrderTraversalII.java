package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Binary Tree Level Order Traversal II 
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * 
 * http://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 
 * Hint: Same as binary tree level order traversal i. Only difference is add the result in the head.
 */
public class BinaryTreeLevelOrderTraversalII {
	public class Solution {
		public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> level = new ArrayList<Integer>();
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			if (root == null)
				return res;
			queue.offer(root);
			queue.offer(null);
			while (true) {
				TreeNode top = queue.poll();
				if (top == null) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.addAll(level);
					//diff
					res.add(0, tmp);
					if (queue.size() == 0)
						break;
					level.clear();
					queue.offer(null);

				} else {
					level.add(top.val);
					if (top.left != null)
						queue.offer(top.left);
					if (top.right != null)
						queue.offer(top.right);
				}
			}
			return res;
		}
	}
}
