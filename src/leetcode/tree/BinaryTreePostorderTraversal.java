package leetcode.tree;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Binary Tree Postorder Traversal 
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * http://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {
	public class Solution {
	    public ArrayList<Integer> postorderTraversal(TreeNode root) {
	        ArrayList<Integer>res=new ArrayList<Integer>();
	        if(root==null) return res;
	        Stack<TreeNode> stack=new Stack<TreeNode>();
	        TreeNode head=root;
	        stack.push(head);
	        while(!stack.isEmpty()){
	            TreeNode next=stack.peek();
	            if(next.left==head||next.right==head||(next.left==null&&next.right==null)){
	                res.add(stack.pop().val);
	                head=next;
	            }else{
	                if(next.right!=null) stack.push(next.right);
	                if(next.left!=null) stack.push(next.left);
	            }
	        }
	        return res;
	    }
	}
}
