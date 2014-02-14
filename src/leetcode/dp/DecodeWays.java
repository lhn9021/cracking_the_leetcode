package leetcode.dp;
/*
 * Decode Ways
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * 
 * http://oj.leetcode.com/problems/decode-ways/
 * 
 * Hint: Be careful with 0.
 */
public class DecodeWays {
	public class Solution {
	    public int numDecodings(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(s.length()==0||s==null) return 0;
	        int length=s.length();
	        int[] result=new int[length+1];
	        result[length]=1;
	        for(int i=length-1;i>-1;i--){
	            if(s.charAt(i)!='0'){
	                result[i]=result[i+1];//normal case
	                if(i<length-1&&Integer.parseInt(s.substring(i,i+2))<=26){
	                    result[i]+=result[i+2];//add special case
	                }
	            }
	        }
	        return result[0];
	    }
	}
}
