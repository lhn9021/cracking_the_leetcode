package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Substring with Concatenation of All Words 
 * 
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once 
 * and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].(order does not matter).
 * 
 * http://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 
 * Hint: Use hashmap to record the list of words. 
 * Read substring and if  it is in the hashmap, reduce the value or remove it. Else break and move forward.
 * If the map.size()is 0 record the index.
 */
public class SubstringWithConcatenationOfAllWords {
	public class Solution {
		public ArrayList<Integer> findSubstring(String S, String[] L) {
			// Start typing your Java solution below
			// DO NOT write main() function
			if (L == null || L.length == 0)
				return null;
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			ArrayList<Integer> res = new ArrayList<Integer>();
			for (String s : L) {
				if (map.containsKey(s)) {
					map.put(s, map.get(s) + 1);
				} else {
					map.put(s, 1);
				}
			}
			int i = 0;
			int m = L[0].length();
			int n = L.length;
			while (S.length() - i >= n * m) {
				Map<String, Integer> tmp = new HashMap<String, Integer>(map);
				for (int j = 0; j < n; j++) {
					String sub = S.substring(i + j * m, i + (j + 1) * m);
					if (tmp.containsKey(sub)) {
						if (tmp.get(sub) == 1) {
							tmp.remove(sub);
						} else {
							tmp.put(sub, tmp.get(sub) - 1);
						}
					} else {
						break;
					}
				}
				if (tmp.size() == 0)
					res.add(i);
				i++;
			}
			return res;
		}
	}
}
