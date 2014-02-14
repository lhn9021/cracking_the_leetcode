package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * Anagrams 
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 * http://oj.leetcode.com/problems/anagrams/
 * 
 * Hint: sort every string and put it in hashmap. set value to -1 if there are more than one word
 */
public class Anagrams {
	public class Solution {
		public ArrayList<String> anagrams(String[] strs) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			int n = strs.length;
			ArrayList<String> result = new ArrayList<String>();
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for (int i = 0; i < strs.length; i++) {
				char[] tmp = strs[i].toCharArray();
				Arrays.sort(tmp);
				String s = new String(tmp);
				if (map.containsKey(s)) {
					if (map.get(s) != -1) {
						result.add(strs[map.get(s)]);
						map.put(s, -1);
					}
					result.add(strs[i]);
				} else {
					map.put(s, i);
				}
			}
			return result;
		}
	}
}
