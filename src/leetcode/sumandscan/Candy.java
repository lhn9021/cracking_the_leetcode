package leetcode.sumandscan;

import java.util.Arrays;

/*
 * Candy
 * 
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * 
 * http://oj.leetcode.com/problems/candy/
 * 
 * Hint: Two scans. First, forward scan and +1 if rating is larger than previous's one. 
 * Second, backward scan and to find conflicts and solve them. Then sum up.
 */
public class Candy {
	public class Solution {
	    public int candy(int[] ratings) {
	        int[] candy=new int[ratings.length];  
	        Arrays.fill(candy, 1);  
	        for(int i=1;i<ratings.length;i++){  
	            if(ratings[i]>ratings[i-1])  
	            	candy[i]=candy[i-1]+1;  
	        }  
	        for(int i=ratings.length-2;i>=0;i--){  
	            if(candy[i]<=candy[i+1]&&ratings[i]>ratings[i+1])  
	            	candy[i]=candy[i+1]+1;  
	        }  
	        int sum=0;  
	        for(int i=0;i<ratings.length;i++){  
	            sum+=candy[i];  
	        }  
	        return sum;  
	    }
	}
}
