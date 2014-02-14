package leetcode.dfsbfs;

import java.util.ArrayList;

/*
 * Palindrome Partitioning
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * 
 * http://oj.leetcode.com/problems/palindrome-partitioning/
 * 
 * Hint: DFS. 
 * You can also use dp to solve the question. dp[i][j] represents whether it is palindrome from i to j
 */
public class PalindromePartitioning {
	public class Solution {
		ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();

		boolean isPalin(String s, int i, int j) {
			while (i < j) {
				if (s.charAt(i) != s.charAt(j))
					return false;
				i++;
				j--;
			}
			return true;
		}

		void dfs(String s, int start, ArrayList<String> al) {
			if (start == s.length()) {
				all.add(new ArrayList<String>(al));
				return;
			}
			for (int i = start; i < s.length(); i++) {
				if (isPalin(s, start, i)) {
					al.add(s.substring(start, i + 1));
					dfs(s, i + 1, al);
					al.remove(al.size() - 1);
				}
			}
		}

		public ArrayList<ArrayList<String>> partition(String s) {
			all.clear();
			ArrayList<String> al = new ArrayList<String>();
			dfs(s, 0, al);
			return all;
		}
	}
}
