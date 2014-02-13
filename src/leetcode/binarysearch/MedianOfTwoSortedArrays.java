package leetcode.binarysearch;
/*
 * Median of Two Sorted Arrays 
 * 
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * http://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * Hint: use find Kth element to find the median of two sorted arrays
 * a is separated into a.start to No.pa and (No.pa+1) to a.end, b is separated into b.start to No. (k-pa), No. (k-pa+1) to b.end
 * if a[a_start+pa-1]<b[b_start+pb-1] because there are k-pa elem in "b" and a.size-pa elem in "a" larger
 * than all a.start to No.pa, which size is Math.min(a_size,k/2), the k th element cannot be in a.start to No.pa. 
 * So we discard this part, update k to k-pa and a.start and a.size and continue searching. vice versa.
 * 
 */
public class MedianOfTwoSortedArrays {
	public class Solution {
		public double findKth(int a[], int a_size, int b[], int b_size, int k,int a_start,int b_start){
	        if(a_size>b_size) return findKth(b,b_size,a,a_size,k,b_start,a_start);
	        if(a_size==0) return b[b_start+k-1];
	        if(k==1) return Math.min(a[a_start],b[b_start]);
	        int pa=Math.min(a_size,k/2),pb=k-pa;
	        if(a[a_start+pa-1]<b[b_start+pb-1]){
	            a_start+=pa;
	            return findKth(a,a_size-pa,b,b_size,k-pa,a_start,b_start);
	        }else{
	            b_start+=pb;
	            return findKth(a,a_size,b,b_size-pb,k-pb,a_start,b_start);
	        }
		}
		public double findMedianSortedArrays(int A[],int B[]) {
	        int m=A.length;
	        int n=B.length;
	        int total=m+n;
	        if(total%2==0){
	            return (findKth(A,m,B,n,total/2,0,0)+findKth(A,m,B,n,total/2+1,0,0))/2;
	        }else{
	            return findKth(A,m,B,n,total/2+1,0,0);
	        }
		}
	}
}
