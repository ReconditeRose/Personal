package eulerProblems1_50;
import eulerFunctions.Prime;
import java.util.Arrays;

import EulerProblems.Problem;

/**
 * TODO Put here a description of what this class does.
 *
 * @author olsonmc.
 *         Created Jan 25, 2012.
 */
public class Problem49 implements Problem {

	private boolean isPalindrome(int i){
		String aString = String.valueOf(i);
		return StringPalindrome(aString,0,aString.length()-1);
	}
	
	private boolean StringPalindrome(String A, int a, int b){
		if(b-a<=0){
			return true;
		}
		if(A.charAt(a)==A.charAt(b)){
			return StringPalindrome(A,a+1,b-1);
		}else{
			return false;
		}
	}
	private boolean isPermutation(int i, int j){
		String iString = String.valueOf(i);
		String jString = String.valueOf(j);
		byte[] iArray = iString.getBytes();
		byte[] jArray = jString.getBytes();
		Arrays.sort(iArray);
		Arrays.sort(jArray);
		return Arrays.equals(iArray,jArray);
	}
	
	@Override
	public String solve() {
		System.out.println(isPalindrome(101));
		for(int i = 1489;i<10000;i+=2){
			for(int j =2;j<(10000-i)/2;j+=2){
				if(isPermutation(i,i+j)&&isPermutation(i,i+2*j)&&Prime.isPrime(i+j)&&Prime.isPrime(i+2*j)&&Prime.isPrime(i)){
					return String.format("%d%d%d",i,i+j,i+2*j);
				}
			}
		}
		return "none";
	}

}
