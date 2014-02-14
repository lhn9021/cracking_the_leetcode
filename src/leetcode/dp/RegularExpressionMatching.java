package leetcode.dp;
/*
 * Regular Expression Matching 
 * 
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") ¡ú false
 * isMatch("aa","aa") ¡ú true
 * isMatch("aaa","aa") ¡ú false
 * isMatch("aa", "a*") ¡ú true
 * isMatch("aa", ".*") ¡ú true
 * isMatch("ab", ".*") ¡ú true
 * isMatch("aab", "c*a*b") ¡ú true
 * 
 * http://oj.leetcode.com/problems/regular-expression-matching/
 * 
 * Hint: see comments
 */
public class RegularExpressionMatching {
	public class Solution {
	    public boolean isMatch(String s, String p) {
	        if(s == null || p == null) return false;
	        boolean[][]dp=new boolean[s.length()+1][p.length()+1];
	        dp[0][0]=true;
	        for(int i=1;i<p.length()+1;i++){
	            if(p.charAt(i-1)=='*')
	                dp[0][i]=dp[0][i-2];
	        }
	        for(int i=1;i<s.length()+1;i++){
	            for(int j=1;j<p.length()+1;j++){
	                if(p.charAt(j-1)=='*'){
	                    dp[i][j]|=dp[i][j-2];//* matches 0
	                    if(s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.'){
	                        dp[i][j]|=dp[i-1][j];//* matches one or more
	                    }
	                }else{
	                    dp[i][j]=(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')&&dp[i-1][j-1];
	                }
	            }
	        }
	        return dp[s.length()][p.length()];
	        
	    }
	}
}
