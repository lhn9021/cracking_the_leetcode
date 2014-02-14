package leetcode.dp;
/*
 * Palindrome Partitioning II 
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * http://oj.leetcode.com/problems/palindrome-partitioning-ii/
 * 
 * Hint: cur[i] represents the minimum cut from index i to the end of s
 */
public class PalindromePartitioningII {
	public class Solution {
	    public int minCut(String s) {
	        int len=s.length();
	        int[] cut=new int[len+1];
	        boolean[][] flag=new boolean[len][len];
	        for(int i=0;i<cut.length;i++)   
	            cut[i]=len-1-i;
	        for(int i=len-1;i>=0;i--){
	            for(int j=i;j<len;j++){
	                if(s.charAt(i)==s.charAt(j)&&(j-i<2||flag[i+1][j-1])){
	                    flag[i][j]=true;
	                  //save the minimum of original cut or cut i to end into 2 part: i to j and j+1 to end
	                    cut[i]=Math.min(cut[i],cut[j+1]+1);
	                }
	            }
	        }
	        return cut[0];
	    }
	}
}
