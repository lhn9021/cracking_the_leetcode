package leetcode.dprecursion;
/*
 * Scramble String
 * 
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * 
 * http://oj.leetcode.com/problems/scramble-string/
 * 
 * Hint: sort two string and split these two and compare recursively
 */
import java.util.Arrays;

public class ScrambleString {
	public class Solution {
		public boolean isScramble(String s1, String s2) {
			if (s1.length() != s2.length())
				return false;
			if (s1.equals(s2))
				return true;
			char[] array_s1 = s1.toCharArray();
			Arrays.sort(array_s1);
			String new_s1 = new String(array_s1);
			char[] array_s2 = s2.toCharArray();
			Arrays.sort(array_s2);
			String new_s2 = new String(array_s2);
			if (!new_s1.equals(new_s2))
				return false;
			for (int i = 1; i < s1.length(); i++) {
				String sub_s1 = s1.substring(0, i);
				String sub_s1_res = s1.substring(i);
				{
					String sub_s2 = s2.substring(0, i);
					String sub_s2_res = s2.substring(i);
					if (isScramble(sub_s1, sub_s2)
							&& isScramble(sub_s1_res, sub_s2_res))
						return true;
				}
				{
					String sub_s2 = s2.substring(s1.length() - i);
					String sub_s2_res = s2.substring(0, s1.length() - i);
					if (isScramble(sub_s1, sub_s2)
							&& isScramble(sub_s1_res, sub_s2_res))
						return true;
				}
			}
			return false;
		}
	}
}
