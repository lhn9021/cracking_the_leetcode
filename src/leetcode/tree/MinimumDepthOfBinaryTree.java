package leetcode.tree;
/*
 * Minimum Depth of Binary Tree
 * 
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 * http://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 * 
 * 
 */
public class MinimumDepthOfBinaryTree {
	public class Solution {
	    public int minDepth(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root==null) return 0;
	        int left=minDepth(root.left);
	        int right=minDepth(root.right);
	        if(left>0&&right>0) return Math.min(left,right)+1;
	        else if(left==0&&right==0) return 1;
	        else return left>0 ? left+1:right+1;
	    }
	}
}
