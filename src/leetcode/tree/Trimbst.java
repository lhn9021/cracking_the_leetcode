package leetcode.tree;

public class Trimbst {
/*
 * http://www.ardendertat.com/2012/01/17/programming-interview-questions-26-trim-binary-search-tree/
 * Given the root of a binary search tree and 2 numbers min and max, 
 * trim the tree such that all the numbers in the new tree are between min and max (inclusive). 
 * The resulting tree should still be a valid binary search tree.
 */
	public TreeNode trim(TreeNode root,int min,int max){
		if(root==null) return null;
		root.left=trim(root.left,min,max);
		root.right=trim(root.right,min,max);
		if(root.val>=min&&root.val<=max) return root;
		else if(root.val<min){
			return root.right;
		}else{
			return root.left;
		}
	}
}
