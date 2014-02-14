package leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/*
 * Largest Rectangle in Histogram 
 * 
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * 
 * http://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * Hint: Use stack to  make sure height is ascending in stack and calculate possible max area. h[height.length]=0
 */
public class LargestRectangleInHistogram {
	public class Solution {
	    public int largestRectangleArea(int[] height) {
	        Stack<Integer> stack = new Stack<Integer>();
	        int i = 0;
	        int maxArea = 0;
	        int[] h = new int[height.length + 1];
	        h = Arrays.copyOf(height, height.length + 1);
	        while(i < h.length){
	            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
	                stack.push(i++);
	            }else {
	                int t = stack.pop();
	                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
	            }
	        }
	        return maxArea;
	    }
	}
}
