package leetcode.binarysearch;
/*
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */
public class medianOfTwoSortedArrays {
	public class Solution {
		public double findKth(int a[], int m, int b[], int n, int k,int as,int bs){
	        if(m>n) return findKth(b,n,a,m,k,bs,as);
	        if(m==0) return b[bs+k-1];
	        if(k==1) return Math.min(a[as],b[bs]);
	        int pa=Math.min(m,k/2),pb=k-pa;
	        if(a[as+pa-1]<b[bs+pb-1]){
	            as+=pa;
	            return findKth(a,m-pa,b,n,k-pa,as,bs);
	        }else{
	            bs+=pb;
	            return findKth(a,m,b,n-pb,k-pb,as,bs);
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
