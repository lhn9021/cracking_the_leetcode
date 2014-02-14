package leetcode.tree;
/*
 * Validate Binary Search Tree
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * http://oj.leetcode.com/problems/validate-binary-search-tree/
 * 
 * Hint: TreeNode should grater than min and smaller than max
 */
public class ValidateBinarySearchTree {
	public class Solution {
	    public boolean isValidBST(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	    }
	    public boolean isValidBST(TreeNode root, int min, int max){
	        if(root==null) return true;
	        else if(root.val<=min||root.val>=max) return false;
	        return isValidBST(root.left,min,root.val)&&isValidBST(root.right,root.val,max);
	    }
	}
}
