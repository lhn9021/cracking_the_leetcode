package leetcode.tree;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * http://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * 
 */
public class BinaryTreeInorderTraversal {
	/*
	public class Solution {
	    public ArrayList<Integer> inorderTraversal(TreeNode root) {
	        ArrayList<Integer> res=new ArrayList<Integer>();
	        if(root==null) return res;
	        inorder(root, res);
	        return res;
	    }
	    public void inorder(TreeNode root, ArrayList<Integer> res){
	        if(root==null) return;
	        inorder(root.left,res);
	        res.add(root.val);
	        inorder(root.right,res);
	    }
	}
	*/
	public class Solution {
	public  ArrayList<Integer> inorderTraversal(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        if(root==null) return res;
	        Stack<TreeNode> s = new Stack<TreeNode>();
	        TreeNode cur = root;
	        while(!s.isEmpty()||cur!=null){
	            if(cur!=null){
	                s.push(cur);
	                cur=cur.left;
	            }else{
	                cur=s.pop();
	                res.add(cur.val);
	                cur=cur.right;
	            }
	        }
	        return res;
	    }
	}
}
