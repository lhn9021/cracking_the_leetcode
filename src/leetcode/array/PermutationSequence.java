package leetcode.array;

import java.util.ArrayList;

/*
 * Permutation Sequence 
 * 
 * The set [1,2,3,бн,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * http://oj.leetcode.com/problems/permutation-sequence/
 * 
 * Hint: Notice the 1st number comes by paris(n-1)!. We can use k to find the number and so on
 */
public class PermutationSequence {
	public class Solution {
	    public String getPermutation(int n, int k) {
	        ArrayList<Integer> nums = new ArrayList<Integer>();
	        for(int i=1;i<=n;i++){
	            nums.add(i);
	        }
	        k--;
	        int[] frac_array=new int[n+1];
	        frac_array[0]=1;
	        frac(n,frac_array);
	        int index=0;
	        while(k!=0){
	            int frac = frac_array[n-(index+1)];
	            int targetIndex= k/frac;
	            nums.add(index,nums.remove(index+targetIndex));
	            index++;
	            k=k%frac;
	        }
	        StringBuilder sb=new StringBuilder();
	        for(int i=0;i<nums.size();i++){
	            sb.append(nums.get(i));
	        }
	        return sb.toString();
	    }
	    public void frac(int n,int[]frac_array){
	        for(int i=1;i<=n;i++){
	            frac_array[i]=frac_array[i-1]*i;
	        }
	    }
	}
}
