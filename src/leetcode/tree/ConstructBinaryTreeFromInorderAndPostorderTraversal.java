package leetcode.tree;

import java.util.HashMap;

/*
 * Construct Binary Tree from Inorder and Postorder Traversal 
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * http://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * Hint: Use inorder to calculate number of nodes in left and right
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public class Solution {
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        for(int i=0;i<inorder.length;i++)
	            map.put(inorder[i],i);
	        return buildTree(map,inorder,postorder,0,inorder.length-1,0,postorder.length-1);
	        
	    }
	    
	    public TreeNode buildTree(HashMap<Integer, Integer> map, int[] inorder, int[]postorder, int a, int b, int c, int d){
	        if(b<a || d<c) return null;
	        TreeNode root = new TreeNode(postorder[d]);
	        int i = map.get(postorder[d]);
	        root.left = buildTree(map, inorder, postorder, a,i-1, c,c+i-a-1);//# is i-a
	        root.right = buildTree(map, inorder, postorder, i+1,b, d-b+i,d-1);//# is b-i
	        return root;
	    }
	}
}
