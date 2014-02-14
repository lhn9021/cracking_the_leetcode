package leetcode.tree;
/*
 * Maximum Depth of Binary Tree 
 * 
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * http://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {
	public class Solution {
	    public int maxDepth(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root==null) return 0;
	        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
	    }
	}
}
