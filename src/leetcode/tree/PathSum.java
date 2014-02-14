package leetcode.tree;
/*
 * Path Sum
 * 
 * Given a binary tree and a sum, 
 * determine if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals the given sum.
 * 
 * http://oj.leetcode.com/problems/path-sum/
 * 
 * Hint: recursion
 */
public class PathSum {
	public class Solution {
	    public boolean hasPathSum(TreeNode root, int sum) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root==null) return false;
	        int rest=sum-root.val;
	        if(rest==0&&root.left==null&&root.right==null) return true;
	        return(hasPathSum(root.left,rest)||hasPathSum(root.right,rest));
	    }
	}
}
