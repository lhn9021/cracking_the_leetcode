package leetcode;

/*
 * Wildcard Matching 
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.
 * Some examples:
 * isMatch("aa","a") ¡ú false
 * isMatch("aa","aa") ¡ú true
 * isMatch("aaa","aa") ¡ú false
 * isMatch("aa", "*") ¡ú true
 * isMatch("aa", "a*") ¡ú true
 * isMatch("ab", "?*") ¡ú true
 * isMatch("aab", "c*a*b") ¡ú false
 * 
 * http://oj.leetcode.com/problems/wildcard-matching/
 * 
 * Hint: start record the position of star, save record the index of s when there is a star
 * If s and p doesn't match but star!=-1, p go back to star+1, s go back to ++save
 */
public class WildcardMatching {
	public class Solution {
		public boolean isMatch(String s, String p) {
			int m = s.length();
			int n = p.length();
			int i = 0;
			int j = 0;
			int star = -1;
			int save = 0;
			while (i < m) {
				while (j < n && p.charAt(j) == '*') {
					star = j++;
					save = i;
				}
				if (j == n|| (s.charAt(i) != p.charAt(j) && p.charAt(j) != '?')) {
					if (star < 0)
						return false;
					else {
						i = ++save;
						j = star + 1;
					}
				} else {
					i++;
					j++;
				}
			}
			while (j < n && p.charAt(j) == '*')
				j++;
			return j == n;
		}
	}
}
