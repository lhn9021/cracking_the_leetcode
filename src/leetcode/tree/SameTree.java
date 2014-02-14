package leetcode.tree;
/*
 * Same Tree 
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 * http://oj.leetcode.com/problems/same-tree/
 * 
 * 
 */
public class SameTree {
	public class Solution {
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(p==null) return q==null;
	        if(q==null) return false;
	        if(p.val!=q.val) return false;
	        if(!isSameTree(p.left,q.left)||!(isSameTree(p.right,q.right))) return false;
	        return true;
	    }
	}
}
