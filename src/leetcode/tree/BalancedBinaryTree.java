package leetcode.tree;
/*
 * Balanced Binary Tree
 * 
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * http://oj.leetcode.com/problems/balanced-binary-tree/
 * 
 * Hint: Modified version of maximum depth of binary tree
 */
public class BalancedBinaryTree {
	public class Solution {
	    public boolean isBalanced(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(balance(root)==-1) return false;
	        return true;
	    }
	    public int balance(TreeNode root){
	        if(root==null) return 0;
	        int left=balance(root.left);
	        if(left==-1) return -1;
	        int right=balance(root.right);
	        if(right==-1) return -1;
	        if(Math.abs(right-left)>1) return -1;
	        else return Math.max(right,left)+1;
	    }
	}
}
