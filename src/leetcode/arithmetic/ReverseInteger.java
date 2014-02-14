package leetcode.arithmetic;
/*
 * Reverse Integer 
 * 
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * http://oj.leetcode.com/problems/reverse-integer/
 * 
 * Hint: MOD
 */
public class ReverseInteger {
	public class Solution {
	    public int reverse(int x) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        long r=0;
	        while(x!=0){
	            r=10*r+x%10;
	            x=x/10;
	        }
	        if(r>Integer.MAX_VALUE) r=Integer.MAX_VALUE;
	        if(r<Integer.MIN_VALUE) r=Integer.MIN_VALUE;
	        return (int)r;
	    }
	}
}
