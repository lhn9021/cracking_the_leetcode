package leetcode.arithmetic;

/*
 * Divide Two Integers 
 * 
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * http://oj.leetcode.com/problems/divide-two-integers/
 * 
 * Hint: Watch out Integer.MIN_VALUE, which could cause out of range.
 */
public class DivideTwoIntegers {
	public class Solution {
		public int divide(int dividend, int divisor) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			if (divisor == 0)
				return Integer.MAX_VALUE;
			boolean same = false;
			int a = Math.abs(dividend);
			int b = Math.abs(divisor);
			if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
				same = true;
			if (divisor == Integer.MIN_VALUE) {
				if (dividend == Integer.MIN_VALUE)
					return 1;
				else
					return 0;
			}
			if (dividend == Integer.MIN_VALUE) {
				if (same) {
					return -divide(dividend + b, b) + 1;
				} else {
					return divide(dividend + b, b) - 1;
				}
			}
			if (divisor == 1)
				return dividend;
			if (divisor == -1)
				return -dividend;
			int result = 0;
			while (a >= b) {
				int product = b;
				int i = 1;
				while (a - product >= product) {
					product = product << 1;
					i = i << 1;
				}
				result += i;
				a -= product;
			}
			if (same)
				return result;
			else
				return -result;
		}
	}
}
