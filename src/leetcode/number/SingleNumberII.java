package leetcode.number;

/*
 * Single Number II 
 * 
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * http://oj.leetcode.com/problems/single-number-ii/
 * 
 * Hint: two|=one& A[i] will record bit which occurs twice,
 * one will record bit which occurs once.
 * And we need to remove bit which occurs three, So one &= ~three; two &= ~three;
 */
public class SingleNumberII {
	public class Solution {
		public int singleNumber(int[] A) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			return sol2(A, A.length);
		}

		int sol2(int A[], int n) {
			int one = 0, two = 0, three = 0;
			for (int i = 0; i < n; ++i) {
				two |= one & A[i];
				one ^= A[i];
				three = one & two;
				one &= ~three;
				two &= ~three;
			}
			return one;
		}
	}
}
