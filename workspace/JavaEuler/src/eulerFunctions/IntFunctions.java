package eulerFunctions;

import java.math.BigInteger;
import java.util.Arrays;


public class IntFunctions {


	public static int getLength(BigInteger a) {
		return a.toString().length();
	}

	public static int getLength(int a) {
		int j = 1;
		if (a == 0) {
			return 1;
		}
		for (int i = 1; i < 100000000; i *= 10) {
			if (a >= i) {
				return j;
			} else {
				j++;
			}
		}
		return 10;
	}

	public static boolean isSquare(int i) {
		if (i % 4 == 2 || i % 4 == 3) {
			return false;
		}
		long p = (long) (Math.sqrt(i) + 0.5);

		return (p * p == i);
	}

	public static boolean isSquare(long i) {
		if (i % 4 == 2 || i % 4 == 3) {
			return false;
		}
		long p = (long) (Math.sqrt(i) + 0.5);

		return (p * p == i);
	}
	public static int countDigits(BigInteger a){
		int sum =0;
		for(char b: a.toString().toCharArray()){
			sum+= (int)b-48;
		}
		return sum;
	}
	public static boolean isInteger(double a){
		return (a == Math.floor(a));
		}
	
	public static boolean isPermutation(int i, int j){
		String iString = String.valueOf(i);
		String jString = String.valueOf(j);
		byte[] iArray = iString.getBytes();
		byte[] jArray = jString.getBytes();
		Arrays.sort(iArray);
		Arrays.sort(jArray);
		return Arrays.equals(iArray,jArray);
	}
	public static boolean isPermutation(long i, long j){
		String iString = String.valueOf(i);
		String jString = String.valueOf(j);
		byte[] iArray = iString.getBytes();
		byte[] jArray = jString.getBytes();
		Arrays.sort(iArray);
		Arrays.sort(jArray);
		return Arrays.equals(iArray,jArray);
	}
	public static int intAtIndex(long i, int index){
		return (int) ((i/(Math.pow(10,index+1)))%10);
	}


}

	