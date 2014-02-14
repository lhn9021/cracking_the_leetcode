package leetcode.tree;
/*
 * Unique Binary Search Trees
 * 
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * http://oj.leetcode.com/problems/unique-binary-search-trees/
 * 
 * Hint: Catalan number
 * http://en.wikipedia.org/wiki/Catalan_number
 */
public class UniqueBinarySearchTrees {
	public class Solution {
		public int numTrees(int n) {
		    int c = 1;
		    for (int i = 2; i <= n; i++)
		        c = 2*(2*i-1)*c/(i+1);
		    return c;
		}
	}
}
