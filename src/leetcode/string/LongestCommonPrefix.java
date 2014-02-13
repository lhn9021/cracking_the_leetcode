package leetcode.string;

/*
 * Longest Common Prefix 
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * http://oj.leetcode.com/problems/longest-common-prefix/
 * 
 * Hint: use the 1st str in array and compare to others.
 */
public class LongestCommonPrefix {
	public class Solution {
		public String longestCommonPrefix(String[] strs) {
			if (strs.length == 0)
				return new String();
			for (int i = 0; i < strs[0].length(); i++) {
				for (int j = 1; j < strs.length; j++) {
					if (i > strs[j].length() - 1|| strs[0].charAt(i) != strs[j].charAt(i))
						return strs[0].substring(0, i);
				}
			}
			return strs[0];
		}
	}

}
