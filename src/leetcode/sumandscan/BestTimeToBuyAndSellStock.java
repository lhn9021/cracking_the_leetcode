package leetcode.sumandscan;
/*
 * Best Time to Buy and Sell Stock 
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * 
 * http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Hint: update low and profit through scan
 */
public class BestTimeToBuyAndSellStock {
	public class Solution {
		public int maxProfit(int[] prices) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			int profit = 0;
			int low = Integer.MAX_VALUE;
			for (int i = 0; i < prices.length; i++) {
				if (prices[i] < low)
					low = prices[i];
				if (prices[i] - low > profit)
					profit = prices[i] - low;
			}
			return profit;
		}
	}
}
