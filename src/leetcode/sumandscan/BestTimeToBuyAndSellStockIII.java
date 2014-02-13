package leetcode.sumandscan;

/*
 * Best Time to Buy and Sell Stock III 
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 
 * Hint: Two scans. 1st scan to store the max from start to i;
 * 2nd scan, store the max profit  from i to end
 * Sum these two and find the largest.
 */
public class BestTimeToBuyAndSellStockIII {
	public class Solution {
		public int maxProfit(int[] prices) {
			        // Start typing your Java solution below
			        // DO NOT write main() function
			        int min = Integer.MAX_VALUE, max=Integer.MIN_VALUE;
			        int [] forward = new int[prices.length], 
			               backward = new int[prices.length];
			        
			        for(int i=0;i<prices.length;i++){
			            if(prices[i]>min){
			                forward[i]=Math.max(prices[i]-min,forward[i-1]);
			            }else{
			                if(i>0) forward[i]=forward[i-1];
			                min=prices[i];
			            }
			            
			            if(prices[prices.length-1-i]<max){
			                backward[prices.length-1-i]=Math.max(max-prices[prices.length-1-i],backward[prices.length-i]);
			            }else{
			               if(i>0) backward[prices.length-1-i]=backward[prices.length-i];
			               max=prices[prices.length-1-i];
			            }
			        }
			        
			        int res = 0;
			        
			        for(int i=0;i<prices.length;i++){
			            res=Math.max(forward[i]+backward[i],res);
			        }
			        return res;
			    }
		}
}
