package leetcode.array;
/*
 * Remove Duplicates from Sorted Array II 
 * 
 * Follow up for "Remove Duplicates":
 * hat if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesfromSortedArrayII {
	public class Solution {
	    public int removeDuplicates(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(A.length==0) return 0;
	        int index=0;
	        int count=1;
	        for(int i=1;i<A.length;i++){
	            if(A[i]==A[index]){
	                count++;
	                if(count<=2) A[++index]=A[i];
	                else continue;
	            }else{
	                count=1;
	                A[++index]=A[i];
	            }
	        }
	        return index+1;
	    }
	}
}
