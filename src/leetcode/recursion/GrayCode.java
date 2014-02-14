package leetcode.recursion;

import java.util.ArrayList;

/*
 * Gray Code 
 * 
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
 * A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * http://oj.leetcode.com/problems/gray-code/
 * 
 * Hint: user prev graycode to generate. Notice 3 is 1<<1 plus 01 2 is 1<<1 plus 00
 */
public class GrayCode {
	public class Solution {
	    public ArrayList<Integer> grayCode(int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	       ArrayList<Integer> tmp=new ArrayList<Integer>();
	       if(n==0){
	           tmp.add(0);
	           return tmp;
	       }
	       ArrayList<Integer> prev=grayCode(n-1);
	       int high_bit=1<<(n-1);
	       for(int i=prev.size()-1;i>=0;i--){
	           tmp.add(prev.get(i)+high_bit);
	       }
	       prev.addAll(tmp);
	       return prev;
	    }
	}
}
