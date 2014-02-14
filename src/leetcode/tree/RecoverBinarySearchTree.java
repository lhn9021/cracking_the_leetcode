package leetcode.tree;

import java.util.ArrayList;

/*
 * Recover Binary Search Tree
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * 
 * http://oj.leetcode.com/problems/recover-binary-search-tree/
 * 
 * Hint: There may be 0,1 or more elements between the swap.
 * Inorder scan and swap the first and last elements that is not normal
 */
public class RecoverBinarySearchTree {
	public class Solution {
	    ArrayList<TreeNode> t;
	    TreeNode prev;
	    public void recoverTree(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        t=new ArrayList<TreeNode>();
	        prev=null;
	        inorder(root);
	        int tmp=t.get(0).val;
	        t.get(0).val=t.get(t.size()-1).val;
	        t.get(t.size()-1).val=tmp;
	    }
	    public void inorder(TreeNode root){
	        if(root==null) return;
	        inorder(root.left);
	        if(prev!=null&&prev.val>root.val){
	            if(!t.contains(prev)) t.add(prev);
	            if(!t.contains(root)) t.add(root);
	        }
	        prev=root;
	        inorder(root.right);
	    }
	}

}
