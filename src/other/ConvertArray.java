package other;

public class ConvertArray {
/*
 * Given an array:
 * [a_1, a_2, ..., a_N, b_1, b_2, ..., b_N, c_1, c_2, ..., c_N ]  
 * convert it to:
 * [a_1, b_1, c_1, a_2, b_2, c_2, ..., a_N, b_N, c_N]  
 * in-place using constant extra space.
 */
	public static void convert(int []input){
		if(input==null) return;
		int length=input.length;
		int size=length/3;
		int i=0;
		while(i<length){
			int index=getIndex(i,size);
			while(index<i){
				index=getIndex(index,size);
			}
			swap(i,index,input);;
			i++;
		}
	}
	private static void swap(int i, int index, int[] input) {
		if(input[i]==input[index])return;
		input[i]=input[i]^input[index];
		input[index]=input[i]^input[index];
		input[i]=input[i]^input[index];
		
	}
	public static int getIndex(int i,int size){
		return i%3*size+i/3;
	}
	public static void main(String[] str){
		int [] input={1,2,3,4,5,6,7,8,9};
		convert(input);
		for(int i:input){
			System.out.print(i+" ");
		}
	}
}
