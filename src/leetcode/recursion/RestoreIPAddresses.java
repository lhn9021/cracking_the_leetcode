package leetcode.recursion;

import java.util.ArrayList;

/*
 * Restore IP Addresses 
 * 
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * http://oj.leetcode.com/problems/restore-ip-addresses/
 * 
 * Hint: If prefix starts with 0, it can only be 0.
 */
public class RestoreIPAddresses {
	public class Solution {
		public ArrayList<String> restoreIpAddresses(String s) {
			if (s.length() < 4 || s.length() > 12)
				return new ArrayList<String>();
			return recur(s, 3);
		}

		public ArrayList<String> recur(String s, int dot) {
			ArrayList<String> validSuffix = new ArrayList<String>();
			if (dot == 0) {
				if (s.length() > 0 && Integer.parseInt(s) < 256)
					if (s.length() == 1 || !s.startsWith("0"))
						validSuffix.add(s);
			} else {
				for (int i = 1; i <= Math.min(s.length(), 3); i++) {
					String prefix = s.substring(0, i);
					// skip if > 256
					if (i == 3 && Integer.parseInt(prefix) > 255)
						break;
					for (String suffix : recur(s.substring(i), dot - 1)) {
						validSuffix.add(prefix + "." + suffix);
					}
					// Skip the rest if the first digit is zero
					if (prefix.startsWith("0"))
						break;
				}
			}
			return validSuffix;
		}
	}
}
