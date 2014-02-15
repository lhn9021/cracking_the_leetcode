package leetcode.tree;
/*
 * Convert Sorted Array to Binary Search Tree 
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * http://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 */
public class ConvertSortedArrayToBinarySearchTree {
	public class Solution {
	    public TreeNode sortedArrayToBST(int[] num) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(num.length==0) return null;
	        return bst(num,0,num.length-1);
	        
	    }
	    public TreeNode bst(int[]num,int start,int end){
	        if(start>end) return null;
	        int median=start+(end-start)/2;
	        TreeNode root=new TreeNode(num[median]);
	        root.left=bst(num,start,median-1);
	        root.right=bst(num,median+1,end);
	        return root;
	    }
	}
}
