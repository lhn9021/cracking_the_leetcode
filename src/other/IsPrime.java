package otehr;
import java.util.ArrayList;


public class IsPrime {

	public static boolean isPrime(int k){
		if(k<=1) return false;
		if(k==2) return true;
		if(k%2==0) return false;
		for(int i=3;i<=Math.sqrt(k);i+=2){
			if(k%i==0){
				return false;
			}
		}
		return true;
	}
	public static boolean isPrimeCheck(int k){
		if(k<=1) return false;
		if(k==2) return true;
		for(int i=2;i<k;i++){
			if(k%i==0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[]args){
		for(int i=1;i<100;i++){
			System.out.println(i+" isPrime is "+isPrime(i));
			if(isPrime(i)!=isPrimeCheck(i)){
				System.err.println("Doesn't match");
			}
		}
	}
}
