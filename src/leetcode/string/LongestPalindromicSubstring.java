package leetcode.string;

/*
 * Longest Palindromic Substring
 * 
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 
 * http://oj.leetcode.com/problems/longest-palindromic-substring/
 * 
 * Hint: http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
 * Easy way is to try every possible palindromic substrings.
 * 
 */
public class LongestPalindromicSubstring {
	public class Solution {
		public String preProcess(String s) {
			int n = s.length();
			if (n == 0)
				return "^$";
			String ret = "^";
			for (int i = 0; i < n; i++)
				ret += "#" + s.substring(i, i + 1);

			ret += "#$";
			return ret;
		}

		public String longestPalindrome(String s) {
			String T = preProcess(s);
			int n = T.length();
			int[] P = new int[n];
			int C = 0, mx = 0;
			for (int i = 1; i < n - 1; i++) {
				int i_mirror = 2 * C - i; // equals to i' = C - (i-C)

				P[i] = (mx > i) ? Math.min(mx - i, P[i_mirror]) : 0;

				// Attempt to expand palindrome centered at i
				while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i]))
					P[i]++;

				// If palindrome centered at i expand past R,
				// adjust center based on expanded palindrome.
				if (i + P[i] > mx) {
					C = i;
					mx = i + P[i];
				}
			}

			// Find the maximum element in P.
			int maxLen = 0;
			int centerIndex = 0;
			for (int i = 1; i < n - 1; i++) {
				if (P[i] > maxLen) {
					maxLen = P[i];
					centerIndex = i;
				}
			}

			return s.substring((centerIndex - 1 - maxLen) / 2,
					(centerIndex - 1 - maxLen) / 2 + maxLen);
		}
		// public String longestPalindrome(String s) {
		// // Note: The Solution object is instantiated only once and is reused
		// by each test case.
		// int n=s.length();
		// String result="";
		// for(int i=0;i<2*n-1;i++){
		// int l=i/2,r=i/2+1;
		// if(i%2==0)l=i/2-1;
		// while(l>=0&&r<n&&s.charAt(l)==s.charAt(r)){
		// l--;
		// r++;
		// }
		// if(r-l-1>result.length())
		// result=s.substring(l+1,r);
		// }
		// return result;
		// }
	}
}
