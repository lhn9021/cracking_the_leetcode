package leetcode.tree;

import java.util.ArrayList;

/*
 * Unique Binary Search Trees II
 * 
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 * http://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 * 
 * Hint: seperate numbers int root, root.left and root.right
 */
public class UniqueBinarySearchTreesII {
	public class Solution {
		class TreeNode{
			TreeNode left,right;
			int value;
			TreeNode(int a){
				this.value=a;
			}
		}
		public ArrayList<TreeNode> generateTrees(int n) {
			return generateTrees(1, n);
		}

		public ArrayList<TreeNode> generateTrees(int a, int b) {
			ArrayList<TreeNode> res = new ArrayList<TreeNode>();
			if (a > b)
				res.add(null);
			else if (a == b)
				res.add(new TreeNode(a));
			else if (a < b) {
				for (int i = a; i <= b; i++) {
					ArrayList<TreeNode> left = generateTrees(a, i - 1);
					ArrayList<TreeNode> right = generateTrees(i + 1, b);
					for (TreeNode l : left) {
						for (TreeNode r : right) {
							TreeNode n = new TreeNode(i);
							n.left = l;
							n.right = r;
							res.add(n);
						}
					}
				}
			}
			return res;

		}
	}
}
