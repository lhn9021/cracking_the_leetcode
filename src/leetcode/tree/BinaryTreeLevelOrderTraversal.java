package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Binary Tree Level Order Traversal 
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * http://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * 
 */
public class BinaryTreeLevelOrderTraversal {
	public class Solution {
		public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
			ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> level = new ArrayList<Integer>();
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			if (root == null)
				return results;
			queue.offer(root);
			queue.offer(null);
			while (true) {
				TreeNode top = queue.poll();
				if (top == null) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.addAll(level);
					results.add(tmp);
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
			return results;
		}
	}
}
