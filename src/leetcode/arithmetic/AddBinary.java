package leetcode.arithmetic;

/*
 * Add Binary 
 * 
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * http://oj.leetcode.com/problems/add-binary/
 * 
 * Hint:
 */
public class AddBinary {
	public class Solution {
		public String addBinary(String a, String b) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			StringBuilder sb = new StringBuilder();
			int l1 = a.length();
			int l2 = b.length();
			int carry = 0;
			for (int i = 0; i < Math.max(l1, l2); i++) {
				int sum = get(a, l1 - 1 - i) + get(b, l2 - 1 - i) + carry;
				carry = sum / 2;
				sb.append(sum % 2);
			}
			if (carry == 1)
				sb.append(1);
			return sb.reverse().toString();
		}

		public int get(String n, int index) {
			if (index < 0)
				return 0;
			else {
				return n.charAt(index) - '0';
			}

		}
	}
}
