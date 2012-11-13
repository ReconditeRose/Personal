package eulerProblems1_50;

import eulerFunctions.Prime;

import java.util.Arrays;

import EulerProblems.Problem;

/**
 * TODO Put here a description of what this class does.
 *
 * @author olsonmc.
 *         Created Jan 31, 2012.
 */
public class Problem41 implements Problem{

	private boolean isPandigital(String a){
		byte[] iArray = a.getBytes();
		byte[] jArray = {'1','2','3','4','5','6','7'};
		Arrays.sort(iArray);
		return Arrays.equals(iArray,jArray);
	}
	
	
	@Override
	public String solve() {
		for(int i =7654321; i>0;i-=2){
			if(Prime.isPrime(i)&&isPandigital(String.valueOf(i))){
				return String.valueOf(i);
			}
		}
		return null;
	}

}
