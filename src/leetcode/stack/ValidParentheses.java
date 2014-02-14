package leetcode.stack;

import java.util.Stack;

/*
 * Valid Parentheses 
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * http://oj.leetcode.com/problems/valid-parentheses/
 * 
 * Hint: Always push left parentheses and check when there is right parentheses
 */
public class ValidParentheses {
	public class Solution {
		public boolean isValid(String s) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < s.length(); i++) {
				if (isLeft(s.charAt(i))) {
					stack.push(s.charAt(i));
				} else {
					if (stack.isEmpty())
						return false;
					if (!match(stack.pop(), s.charAt(i)))
						return false;
				}
			}
			if (!stack.isEmpty())
				return false;
			return true;
		}

		public boolean isLeft(char c) {
			return c == '{' || c == '[' || c == '(';
		}

		public boolean match(char c, char d) {
			return (c == '(' && d == ')') || (c == '[' && d == ']')
					|| (c == '{' && d == '}');
		}
	}
}
