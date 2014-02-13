package leetcode.string;
/*
 * Longest Substring Without Repeating Characters 
 * 
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * http://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Hint:Use constant space to store whether the character has been existed.
 * Two indexes. i is the head of non repeating sequence, j is current index.
 * If s.charAt(j) has been marked existed, then we need calculate the length that satisfy the condition, advance i and 
 * set boolean array existed to false until s.charAt(i)==s.charAt(j)
 * After this, i++ and j++. At that time, the substring from i to j-1 has no duplicates.
 * If no duplicate, just mark the char as existed.
 * The time complexity is O(N) since i j never go back.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public class Solution {
		public int lengthOfLongestSubstring(String s) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			int longest = 0;
			int i = 0, j = 0;
			int n = s.length();
			boolean[] existed = new boolean[256];
			while (j < n) {
				if (existed[s.charAt(j)]) {
					longest = Math.max(longest, j - i);
					while (s.charAt(i) != s.charAt(j)) {
						existed[s.charAt(i)] = false;
						i++;
					}
					i++;
					j++;
				} else {
					existed[s.charAt(j)] = true;
					j++;
				}
			}
			return Math.max(longest, n - i);
		}
	}
}
