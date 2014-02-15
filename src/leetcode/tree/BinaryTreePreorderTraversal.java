package leetcode.tree;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Binary Tree Preorder Traversal 
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * http://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {
	public class Solution {
	    public ArrayList<Integer> preorderTraversal(TreeNode root){
	        ArrayList<Integer> res=new ArrayList<Integer>();
	        Stack<TreeNode> stack=new Stack<TreeNode>();
	        if(root==null) return res;
	        stack.push(root);
	        while(!stack.isEmpty()){
	            TreeNode node=stack.pop();
	            res.add(node.val);
	            if(node.right!=null) stack.push(node.right);
	            if(node.left!=null) stack.push(node.left);
	        }
	        return res;
	    }
	}
}
