package leetcode.arithmetic;
/*
 * Sqrt(x) 
 * 
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * 
 * http://oj.leetcode.com/problems/sqrtx/
 * 
 * Hint: Newtown's method
 */
public class sqrt {
	public class Solution {
	    public int sqrt(int x) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(x<0) return -1;
	        if(x==0) return 0;
	        double y=((double)x)/2.;
	        while(Math.abs(y*y-x)>0.00001){
	            y=(y+x/y)/2;
	        }
	        return (int)y;
	    }
	}
}
