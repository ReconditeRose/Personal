package eulerProblems51_100;
import eulerFunctions.*;

import java.math.BigInteger;

import EulerProblems.Problem;

public class Problem63 implements Problem {

	@Override
	public String solve() {
		int sum =0;
		for(int i =1;i<=10;i++){
			BigInteger a = new BigInteger(String.valueOf(i));
			BigInteger mult = new BigInteger(String.valueOf(i));
			int power = 1;
			while(IntFunctions.getLength(a)==power){
				sum++;
				a=a.multiply(mult);
				power++;
				System.out.println(a.toString());
			}
		}
		
		return String.valueOf(sum);
	}

}
