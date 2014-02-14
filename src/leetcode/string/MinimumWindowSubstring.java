package leetcode.string;
/*
 * Minimum Window Substring 
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * http://oj.leetcode.com/problems/minimum-window-substring/
 * 
 * Hint£ºtrack hasFound and needToFind.
 * Use begin as the beginning of the window
 * When count=T.length(), move begin to the minimum window spot and calculate len 
 */
public class MinimumWindowSubstring {
	public class Solution {
	    public String minWindow(String S, String T) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int sLen = S.length();
	        int tLen = T.length();
	        int minWindowBegin=-1;
	        int[] needToFind = new int[256];
	        int[] hasFound = new int[256];
	        int minWindowLen = S.length()+1;
		    for (int i = 0; i < T.length(); i++) {
		        needToFind[(int)T.charAt(i)]++; 
		    }
	        int count = 0;
	        for (int begin = 0, ptr = 0; ptr < sLen; ptr++) {
	            if(needToFind[S.charAt(ptr)]==0) continue;
	            hasFound[S.charAt(ptr)]++;
	            if(hasFound[S.charAt(ptr)]<=needToFind[S.charAt(ptr)]){
	                count++;
	            }
	            if(count==T.length()){
	                while(needToFind[S.charAt(begin)]==0||hasFound[S.charAt(begin)]>needToFind[S.charAt(begin)]){
	                    if(hasFound[S.charAt(begin)]>needToFind[S.charAt(begin)]) hasFound[S.charAt(begin)]--;
	                    begin++;
	                }
	                int len=ptr+1-begin;
	                if(len<minWindowLen){
	                    minWindowLen=len;
	                    minWindowBegin=begin;
	                }
	            }
	        }
	        if(count!=tLen) return new String();
	        return S.substring(minWindowBegin,minWindowBegin+minWindowLen);
	    }
	}
}
