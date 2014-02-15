package leetcode.tree;

import java.util.ArrayList;

/*
 * Binary Tree Zigzag Level Order Traversal 
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * http://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * Hint: Same idea of level order traversal. Add a boolean to change the order.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public class Solution {
	    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		        if(root==null) return res;
		        boolean order = true;
		        ArrayList<TreeNode> toVisit = new ArrayList<TreeNode>();
		        toVisit.add(root);
		        while(!toVisit.isEmpty()){
		            ArrayList<Integer> temp = new ArrayList<Integer>();
		            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
		            for(TreeNode node:toVisit){
		                temp.add(node.val);
		            }
		            res.add(temp);	        
		            for(int i=toVisit.size()-1;i>=0;i--){
		                TreeNode node = toVisit.get(i);
		                if(order){
		                    if(node.right!=null) next.add(node.right);
		                    if(node.left!=null) next.add(node.left);
		                }else{
		                    if(node.left!=null) next.add(node.left);
		                    if(node.right!=null) next.add(node.right);
		                }
		            }
		            order = order?false:true;
		            toVisit = new ArrayList<TreeNode>(next);
		        }
		        return res;
	    }
	}
}
