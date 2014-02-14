package leetcode.recursion;

import java.util.ArrayList;

/*
 * Generate Parentheses
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * http://oj.leetcode.com/problems/generate-parentheses/
 * 
 * Hint: Use two numbers to track the left parentheses and right parentheses.
 */
public class GenerateParentheses {
	public class Solution {
		public ArrayList<String> generateParenthesis(int n) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			ArrayList<String> res = new ArrayList<String>();
			char[] tmp = new char[2 * n];
			recur(0, n, n, tmp, res);
			return res;
		}

		public void recur(int index, int left, int right, char[] tmp,
				ArrayList<String> res) {
			if (left == 0 && right == 0) {
				res.add(new String(tmp));
				return;
			}
			if (left > 0) {
				tmp[index] = '(';
				recur(index + 1, left - 1, right, tmp, res);
			}
			if (right > left) {
				tmp[index] = ')';
				recur(index + 1, left, right - 1, tmp, res);
			}
		}
	}
}
