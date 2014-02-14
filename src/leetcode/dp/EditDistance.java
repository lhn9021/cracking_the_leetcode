package leetcode.dp;
/*
 * Edit Distance 
 * 
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * http://oj.leetcode.com/problems/edit-distance/
 * 
 * Hint: Use matrix to present insert delete and replace.
 */
public class EditDistance {
	public class Solution {
	    public int minDistance(String word1, String word2) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int l1 = word1.length(), l2 = word2.length();
		    int[][] d = new int[l1+1][l2+1];
		    for(int i=0;i<l2+1;i++){
		        d[0][i]=i;
		    }
		    for(int i=0;i<l1+1;i++){
		        d[i][0]=i;
		    }
		    for(int i=1;i<l1+1;i++){
		        for(int j=1;j<l2+1;j++){
		            if(word1.charAt(i-1)==word2.charAt(j-1)){
		            	//no edit
		                d[i][j]=d[i-1][j-1];
		            }else{
		            	//pick the minimum edit steps and plus one
		                d[i][j]=Math.min(d[i-1][j],Math.min(d[i][j-1],d[i-1][j-1]))+1;
		            }
		        }
	        }
	         return d[l1][l2];
	    }
	}
}
