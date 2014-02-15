package leetcode.arithmetic;
/*
 * Pow(x, n) 
 * 
 * Implement pow(x, n).
 * 
 * http://oj.leetcode.com/problems/powx-n/
 * 
 * Hint: Divide an conquer
 */
public class Pow {
	public class Solution {
	    public double pow(double x, int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(n==1) return x;
	        if(n==0) return 1;
	        if(n<0){
	            x=1/x;
	            n=-n;
	        }
	        if(n%2==0){
	            double tmp=pow(x,n/2);
	            return tmp*tmp;
	        }else{
	            double tmp=pow(x,(n-1)/2);
	            return tmp*tmp*x;
	        }
	    }
	}
}
