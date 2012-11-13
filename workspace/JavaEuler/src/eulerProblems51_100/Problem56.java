package eulerProblems51_100;

import java.math.BigInteger;

import EulerProblems.Problem;

/**
 * TODO Put here a description of what this class does.
 *
 * @author olsonmc.
 *         Created Jan 31, 2012.
 */
public class Problem56 implements Problem{

	private int digitalSum(BigInteger a){
		int dsum = 0;
		String b = a.toString();
		for(char c: b.toCharArray()){
			dsum+=Character.getNumericValue(c);
		}
		return dsum;
	}
	@Override
	public String solve() {
		int max = 0;
		for(int b =1;b<100;b++){
			for(int a = 1; a<100; a++){
				BigInteger num = new BigInteger(String.valueOf(b));
				num = num.pow(a);
				int tempMax = digitalSum(num);
				if(tempMax>max)
					max= tempMax;
				
			}
		}
		
		System.out.println(digitalSum(new BigInteger("55")));
		return String.valueOf(max);
	}

}
