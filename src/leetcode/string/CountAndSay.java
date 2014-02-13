package leetcode.string;

/*
 * Count and Say 
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * 
 * http://oj.leetcode.com/problems/count-and-say/
 * 
 * Hint: 
 */
public class CountAndSay {
	public class Solution {
		public String countAndSay(int n) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			if (n < 0)
				return null;
			StringBuilder sb = new StringBuilder("1");
			while (n-- > 1) {
				StringBuilder tmp = new StringBuilder();
				int count = 1;
				for (int i = 1; i < sb.length(); i++) {
					if (sb.charAt(i) == sb.charAt(i - 1)) {
						count++;
					} else {
						tmp.append(count);
						tmp.append(sb.charAt(i - 1));
						count = 1;
					}
				}
				tmp.append(count);
				tmp.append(sb.charAt(sb.length() - 1));
				sb = tmp;
			}
			return sb.toString();
		}
	}
}
