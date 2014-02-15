package leetcode.tree;
/*
 * Sum Root to Leaf Numbers 
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * 
 * http://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * Hint: Recursion to sum the result
 */
public class SumRootToLeafNumbers {
	public class Solution {
	    public int sumNumbers(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        return sumNumbers(root, 0);
	    }
	    public int sumNumbers(TreeNode root, int result){
	        if(root==null)return 0;
	        if(root.left==null&&root.right==null) return root.val+10*result;
	        return sumNumbers(root.right,root.val+10*result)+sumNumbers(root.left,root.val+10*result);
	    }
	}
}
