package leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Word Break II
 * 
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * http://oj.leetcode.com/problems/word-break-ii/
 * 
 * Hint: Use memo to store the previous result
 */
public class WordBreakII {
	public class Solution {
		public ArrayList<String> wordBreak(String s, Set<String> dict) {
		    // Note: The Solution object is instantiated only once and is reused by each test case.
		    Map <String, ArrayList<String>> memo = new HashMap<String, ArrayList<String>>();
		    return recur(s, dict, memo);
		}

		public ArrayList<String> recur(String s, Set<String> dict, Map<String, ArrayList<String>> memo){
		    if(memo.containsKey(s)) return memo.get(s);
		    ArrayList<String> result = new ArrayList<String>();
		    int n = s.length();
		    if(n <= 0) return result;
		    for(int len = 1; len <= n; ++len){
		        String suffix = s.substring(n-len);
		        if(dict.contains(suffix)){
		            if(len == n){
		                result.add(suffix);//s is a word in dict
		            }else{
		                String prefix = s.substring(0, n-len);
		                ArrayList<String> tmp = recur(prefix, dict, memo);
		                for(String item:tmp){
		                    item = item + " " + suffix;
		                    result.add(item);
		                }
		            }   
		        }
		    }
		    memo.put(s, result);
		    return result;
		}
		}
}
