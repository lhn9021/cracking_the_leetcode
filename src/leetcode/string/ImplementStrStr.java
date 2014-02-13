package leetcode.string;

/*
 * Implement strStr() 
 * 
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * 
 * http://oj.leetcode.com/problems/implement-strstr/
 * 
 * Hint: if the remaining length is less than needle break and return null;
 */
public class ImplementStrStr {
	public class Solution {
		public String strStr(String haystack, String needle) {
			if (needle.length() == 0)
				return haystack;
			int i = 0;
			while (i < haystack.length()) {
				if (haystack.length() - i < needle.length())
					break;
				if (haystack.charAt(i) == needle.charAt(0)) {
					int j = 0;
					while (j < needle.length()
							&& haystack.charAt(i + j) == needle.charAt(j))
						j++;
					if (j == needle.length())
						return haystack.substring(i);
				}
				i++;
			}
			return null;
		}
	}
}
