package leetcode.string;

/*
 * Valid Palindrome 
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * http://oj.leetcode.com/problems/valid-palindrome/
 * 
 * Hint:
 */
public class ValidPalindrome {
	public class Solution {
		public boolean isPalindrome(String s) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			s = s.toLowerCase();
			s = s.replaceAll("[^a-z0-9]", "");
			for (int i = 0; i < s.length() / 2; i++) {
				if (s.charAt(i) != s.charAt(s.length() - 1 - i))
					return false;
			}
			return true;
		}
	}
}
