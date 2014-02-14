package leetcode.number;

/*
 * Plus One 
 * 
 * Given a number represented as an array of digits, plus one to the number.
 * 
 * http://oj.leetcode.com/problems/plus-one/
 * 
 * 
 */
public class PlusOne {
	public class Solution {
		public int[] plusOne(int[] digits) {
			// Start typing your Java solution below
			// DO NOT write main() function
			if (digits.length == 0) {
				return digits;
			}
			int n = digits.length, carry = 1;
			for (int i = n - 1; i >= 0; i--) {
				int sum = digits[i] + carry;
				digits[i] = sum % 10;
				carry = sum / 10;
			}
			if (carry == 0) {
				return digits;
			} else {
				int[] ret = new int[n + 1];
				ret[0] = 1;
				for (int i = 1; i < n + 1; i++) {
					ret[i] = digits[i - 1];
				}
				return ret;
			}
		}
	}
}
