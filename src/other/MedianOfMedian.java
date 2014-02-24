package other;
import java.util.Arrays;


public class MedianOfMedian {
	public static int findKth(int[]A,int K) throws Exception{
		if(K<1||K>A.length){
			throw new Exception("No answer");
		}else if(A.length<=5){
			Arrays.sort(A);
			return A[K-1];
		}
		int numOfMedian=(A.length+4)/5;
		int[] medians= new int[numOfMedian];
		for(int i=0;i<numOfMedian-1;i++){
			medians[i]=findKth(Arrays.copyOfRange(A,5*i, 5*(i+1)),3);
		}
		int[] last=Arrays.copyOfRange(A,A.length-1-(A.length+4)%5,A.length);
		medians[medians.length-1]=findKth(last,(int)Math.ceil((last.length+1)/2));
		int pivot=findKth(medians,(int)Math.ceil((numOfMedian+1)/2));
		int pivotIndex=partition(A,pivot);
		int rank=pivotIndex+1;
		if(K<rank){
			return findKth(Arrays.copyOfRange(A,0,pivotIndex),K);
		}else if(K>rank){
			return findKth(Arrays.copyOfRange(A,pivotIndex+1,A.length),K-rank);
		}else{
			return A[rank-1];
		}
	}
	 public static int partition(int A[], int pivot) {
	        int begin = 0;
	        for (int i=0;i<A.length;i++) {
	            if (A[i]<pivot) {
	                int temp = A[i];
	                A[i] = A[begin];
	                A[begin] = temp;
	                begin++;
	            }
	        }
	        return begin;
	    }
	public static void main(String[] args){
		int[] a={1,1,3,4,5,6,7,8,9,10,11,12,13,14,15};
		try {
			for(int i=1;i<=a.length;i++){
				System.out.println("result is "+findKth(a,i));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
