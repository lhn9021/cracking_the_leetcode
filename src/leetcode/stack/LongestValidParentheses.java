package leetcode.stack;

import java.util.Stack;

/*
 * Longest Valid Parentheses 
 * 
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * http://oj.leetcode.com/problems/longest-valid-parentheses/
 * 
 * Hint: same as valid parentheses. Use left to record valid start
 */
public class LongestValidParentheses {
	public class Solution {
		public int longestValidParentheses(String s) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			int i = 0;
			int max = 0;
			int left = 0;
			Stack<Integer> stack = new Stack<Integer>();
			while (i < s.length()) {
				if (s.charAt(i) == '(') {
					stack.push(i);
				} else {
					if (stack.isEmpty())
						left = i + 1;
					else {
						stack.pop();
						if (stack.isEmpty()) {
							max = Math.max(max, i + 1 - left);
						} else {
							max = Math.max(max, i + 1 - stack.peek() - 1);
						}
					}
				}
				i++;
			}
			return max;
		}
	}
}
