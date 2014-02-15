package leetcode.tree;

import java.util.HashMap;

/*
 * Construct Binary Tree from Preorder and Inorder Traversal 
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * http://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * Hint: Use inorder to calculate number of nodes in left and right
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public class Solution {
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        for(int i=0;i<inorder.length;i++)
	            map.put(inorder[i],i);
	        return buildTree(map,preorder,inorder,0,preorder.length-1,0,inorder.length-1);
	    }
	    public TreeNode buildTree(HashMap<Integer, Integer> map, int[] preorder, int[]inorder, int a, int b, int c, int d){
	        if(b<a || d<c) return null;
	        TreeNode root = new TreeNode(preorder[a]);
	        int i = map.get(preorder[a]);
	        root.left = buildTree(map, preorder, inorder, a+1,a+i-c,c,i-1);//# is i-c
	        root.right = buildTree(map, preorder, inorder, b+1+i-d,b,i+1,d);//# is d-i
	        return root;
	    }
}
}
