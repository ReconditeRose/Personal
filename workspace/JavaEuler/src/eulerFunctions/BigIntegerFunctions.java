package eulerFunctions;

import java.math.BigInteger;
import java.util.Arrays;

public class BigIntegerFunctions {
	public static boolean frontPanDigital(BigInteger a){
		String b = a.toString();
		return sectionPanDigital(b,0,9);
	}
	public static boolean backPanDigital(BigInteger a){
		String b = a.toString();
		return sectionPanDigital(b,b.length()-9,b.length());
	}
	private static boolean sectionPanDigital(String a, int begin, int end){
			byte[] iArray = a.substring(begin, end).getBytes();
			byte[] jArray = {'1','2','3','4','5','6','7','8','9'};
			Arrays.sort(iArray);
			return Arrays.equals(iArray,jArray);
	}
	public static boolean bothPanDigital(BigInteger a){
		return(frontPanDigital(a) && backPanDigital(a));
	}
	
	public static void main(String[] args) {
//		BigInteger a,b,c,d;
//		a = new BigInteger("12345678911");
//		b = new BigInteger("11123456789");
//		c = new BigInteger("12345678911123456789");
//
//		d = a;
//		System.out.println(frontPanDigital(d));
//		System.out.println(backPanDigital(d));
//		System.out.println(bothPanDigital(d));
//		
//		d = b;
//		System.out.println(frontPanDigital(d));
//		System.out.println(backPanDigital(d));
//		System.out.println(bothPanDigital(d));
//		
//		d = c;
//		System.out.println(frontPanDigital(d));
//		System.out.println(backPanDigital(d));
//		System.out.println(bothPanDigital(d));
		
		
	}
	
	
}
