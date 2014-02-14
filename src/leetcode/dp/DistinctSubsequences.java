package leetcode.dp;

/*
 * Distinct Subsequences 
 * 
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * 
 * http://oj.leetcode.com/problems/distinct-subsequences/
 * 
 * Hint: two type of match. First one is T matches S with s.charAt(i) is the last char, 
 * second one is T matches S without s.charAt(i)
 */
public class DistinctSubsequences {
	public class Solution {
		public int numDistinct(String S, String T) {
			int[] occurence = new int[T.length() + 1];
			occurence[0] = 1;
			for (int i = 0; i < S.length(); i++) {
				for (int j = T.length() - 1; j >= 0; j--)
					if (S.charAt(i) == T.charAt(j)) {
						occurence[j + 1] += occurence[j];// match without i-th char plus match with i-th char
					}
			}
			return occurence[T.length()];
		}
	}
}
/*
1 r a b
r 1 0 0
a 1 1 0
b 1 1 1
b 1 1 2
r 2 1 2
a 2 3 2
b 2 3 5
*/
