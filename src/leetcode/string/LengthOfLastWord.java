package leetcode.string;

/*
 * Length of Last Word 
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 * http://oj.leetcode.com/problems/length-of-last-word/
 * 
 * Hint: 
 */
public class LengthOfLastWord {
	public class Solution {
		public int lengthOfLastWord(String s) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			int index = s.length() - 1;
			int count = 0;
			while (index >= 0 && s.charAt(index) == ' ')
				index--;

			while (index >= 0 && s.charAt(index) != ' ') {
				count++;
				index--;
			}
			return count;
		}
	}
}
