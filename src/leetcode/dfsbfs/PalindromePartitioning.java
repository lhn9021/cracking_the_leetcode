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
	public ArrayList<ArrayList<String>> partition(String s) {
	    if(s == null || s.length() == 0)
	        return new ArrayList<ArrayList<String>>();
	    int len=s.length();
	    boolean[][] flag = new boolean[len][len];
	    for(int i=len-1;i>=0;i--){
	            for(int j=i;j<len;j++){
	                if(s.charAt(i)==s.charAt(j)&&(j-i<2||flag[i+1][j-1])){
	                    flag[i][j]=true;
	                }
	            }
	        }
	    return method(s, flag,0);
	}
	private ArrayList<ArrayList<String>> method(String s, boolean[][] b, int start) {
			ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

			if (start == s.length())
				return result;

			if (s.length() - start == 1) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(s.substring(start));
				result.add(list);
				return result;
			}

			for (int i = start; i < s.length(); i++) {
				if (b[start][i]) {
					ArrayList<ArrayList<String>> l = this.method(s, b, i + 1);
					int length = l.size();
					if (length == 0) {
						ArrayList<String> temp = new ArrayList<String>();
						temp.add(s.substring(start, i + 1));
						l.add(temp);
					} else {
						for (int j = 0; j < length; j++) {
							ArrayList<String> temp = l.remove(0);
							temp.add(0, s.substring(start, i + 1));
							l.add(temp);
						}
					}
					result.addAll(l);
				}
			}

			return result;
		}

	
//	public class Solution {
//		ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
//
//		boolean isPalin(String s, int i, int j) {
//			while (i < j) {
//				if (s.charAt(i) != s.charAt(j))
//					return false;
//				i++;
//				j--;
//			}
//			return true;
//		}
//
//		void dfs(String s, int start, ArrayList<String> al) {
//			if (start == s.length()) {
//				all.add(new ArrayList<String>(al));
//				return;
//			}
//			for (int i = start; i < s.length(); i++) {
//				if (isPalin(s, start, i)) {
//					al.add(s.substring(start, i + 1));
//					dfs(s, i + 1, al);
//					al.remove(al.size() - 1);
//				}
//			}
//		}
//
//		public ArrayList<ArrayList<String>> partition(String s) {
//			all.clear();
//			ArrayList<String> al = new ArrayList<String>();
//			dfs(s, 0, al);
//			return all;
//		}
//	}
}
