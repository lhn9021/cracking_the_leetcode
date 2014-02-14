package leetcode.arithmetic;

/*
 * Palindrome Number 
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * http://oj.leetcode.com/problems/palindrome-number/
 * 
 * Hint: Mod and Divide
 */
public class PalindromeNumber {
	public class Solution {
		public boolean isPalindrome(int x) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			if (x < 0)
				return false;
			int div = 1;
			while (x / div >= 10) {
				div *= 10;
			}
			while (x != 0) {
				if (x % 10 != x / div)
					return false;
				x = (x % div) / 10;
				div /= 100;
			}
			return true;
		}
	}
}
