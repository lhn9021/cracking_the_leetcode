package leetcode.stack;

import java.util.Stack;

/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * http://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * 
 */
public class EvaluateReversePolishNotation {
	public class Solution {
		public int evalRPN(String[] tokens) {
			Stack<Integer> stack = new Stack<Integer>();
			for (int i = 0; i < tokens.length; i++) {
				if (tokens[i].equals("+") || tokens[i].equals("-")
						|| tokens[i].equals("*") || tokens[i].equals("/")) {
					int op2 = stack.pop();
					int op1 = stack.pop();
					int result = 0;
					if(tokens[i].equals("+"))
						result = op1 + op2;
					else if(tokens[i].equals("-"))
						result = op1 - op2;
					else if(tokens[i].equals("*"))
						result = op1 * op2;
					else if(tokens[i].equals("/"))
						result = op1 / op2;
					stack.push(result);
				} else
					stack.push(Integer.parseInt(tokens[i]));
			}
			return stack.pop();
		}
	}
}
