package leetcode.dp;

/*
 * Interleaving String
 * 
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 * http://oj.leetcode.com/problems/interleaving-string/
 * 
 * Hint: dp[i][j] stands for whether first i chars in s1 and first j chars in s2 can match the first i+j chars in s3.
 */
public class InterleavingString {
	public class Solution {
		public boolean isInterleave(String s1, String s2, String s3) {
			if (s1 == null || s2 == null || s3 == null)
				return false;
			int l1 = s1.length();
			int l2 = s2.length();
			int l3 = s3.length();
			if (l1 + l2 != l3)
				return false;
			boolean[][] dp = new boolean[l1 + 1][l2 + 1];
			dp[0][0] = true;
			for (int i = 0; i <= s1.length(); i++)
				for (int j = 0; j <= s2.length(); j++) {
					if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)
							&& dp[i - 1][j])
						dp[i][j] = true;

					if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)
							&& dp[i][j - 1])
						dp[i][j] = true;
				}

			return dp[l1][l2];
		}
	}
}
