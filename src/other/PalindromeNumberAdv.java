package other;

public class PalindromeNumberAdv {
/*
 * Output nearest number greater than given number such that output is 
 * palindrome
 * ex: 121:131
 * 900:909
 * 99:101
 */
	private static int find(int a) {
		int n=a+1;
		String s=Integer.toString(n);
		int length=s.length();
		int[] num=new int[length];
		for(int i=0;i<length;i++){
			num[i]=s.charAt(i)-'0';
		}
		int l=0,r=num.length-1;
		while(l<r){
			if(num[l]<num[r]){
				int pow=(int)Math.pow(10,length-r);
				return find(n+pow-n%pow);
			}else if(num[l]>num[r]){
				n=(int) (n+(num[l]-num[r])*Math.pow(10,length-r-1));
				num[r]=num[l];
				l++;
				r--;
			}
			else{
				l++;
				r--;
			}
		}
	
		return n;
	}
	public static void main(String[] args){
		System.out.println(find(1110));
	}
}
