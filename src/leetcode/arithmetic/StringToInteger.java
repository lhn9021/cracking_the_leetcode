package leetcode.arithmetic;

/*
 * String to Integer
 * 
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. 
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 * 
 * http://oj.leetcode.com/problems/string-to-integer-atoi/
 * 
 * Hint: 
 */
public class StringToInteger {
	public class Solution {
		public int atoi(String str) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			long value = 0;
			String s = str.trim();
			boolean positive = true;
			for (int i = 0; i < s.length(); i++) {
				if (i == 0 && s.charAt(i) == '-') {
					positive = false;
					continue;
				} else if (i == 0 && s.charAt(i) == '+') {
					continue;
				}
				if (s.charAt(i) < '0' || s.charAt(i) > '9')
					break;
				value = 10 * value + s.charAt(i) - '0';
			}
			if (!positive)
				value = -1 * value;
			if (value > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else if (value < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			return (int) value;
		}
	}
}
