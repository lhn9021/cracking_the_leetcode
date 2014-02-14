package leetcode.tree;
/*
 * Flatten Binary Tree to Linked List 
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * http://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * Hint: swap left and right and find the rightmost node and attach left to it.
 */
public class FlattenBinaryTreeToLinkedList {
	public class Solution {
	    public void flatten(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root==null) return;
	        TreeNode end=root;
	        if(root.left!=null){
	            TreeNode tmp=root.right;
	            root.right=root.left;
	            root.left=tmp;
	            while(end.right!=null)end=end.right;
	            end.right=root.left;
	            root.left=null;
	        }
	        flatten(root.right);
	        
	    }
	}
}
