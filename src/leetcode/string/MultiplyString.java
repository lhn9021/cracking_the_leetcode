package leetcode.string;
/*
 * Multiply Strings 
 * 
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * http://oj.leetcode.com/problems/multiply-strings/
 * 
 * Hint: Start from the end of two number. Remember to handle the carry.
 */
public class MultiplyString {
	public class Solution {
		public String multiply(String num1, String num2) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			int[] res = new int[num1.length() + num2.length()];
			for (int i = 0; i < num2.length(); i++) {
				int b = num2.charAt(num2.length() - 1 - i) - '0';
				int carry = 0;
				for (int j = 0; j < num1.length(); j++) {
					int a = num1.charAt(num1.length() - 1 - j) - '0';
					res[i + j] += a * b + carry;
					carry = res[i + j] / 10;
					res[i + j] %= 10;
				}
				res[i + num1.length()] += carry;
			}
			int i = res.length - 1;
			while (i > 0 && res[i] == 0) {
				i--;
			}
			StringBuilder sb = new StringBuilder();
			while (i >= 0) {
				sb.append(res[i--]);
			}
			return sb.toString();
		}
	}
}
