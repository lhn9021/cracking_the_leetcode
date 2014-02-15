package leetcode.array;
/*
 * Next Permutation 
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 ¡ú 1,3,2
 * 3,2,1 ¡ú 1,2,3
 * 1,1,5 ¡ú 1,5,1
 * 
 * http://oj.leetcode.com/problems/next-permutation/
 * 
 * Hint: Find the num[i]>num[i-1] from back.
 * Swap all from i to end.
 * Find the 1st number that is larger than num[i-1]
 * Swap these two.
 * If there is no answer, swap all
 */
public class NextPermutation {
	public class Solution {
	    public void nextPermutation(int[] num) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int n = num.length;
	        for(int i=n-1;i>=1;i--){
	            if(num[i]>num[i-1]){
	                swapRange(num,i,n-1);
	                for(int j=i;j<n;j++){
	                    if(num[i-1]<num[j]){
	                        swap(num,i-1,j);
	                        return;
	                    }
	                }
	            }
	        }
	        swapRange(num,0,n-1);
	    }
	    public void swapRange(int[] num, int start, int end) {
	        for (int i = start, j = end; i < j; i++, j--) {
	            swap(num, i, j);
	        }
	    }
	    public void swap(int[] num, int i, int j) {
	        if (num[i] == num[j]) return;
	        num[i] = num[i]^num[j];
	        num[j] = num[i]^num[j];
	        num[i] = num[i]^num[j];
	    }
	}
}
