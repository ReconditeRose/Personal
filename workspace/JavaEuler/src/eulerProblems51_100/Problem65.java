package eulerProblems51_100;
import eulerFunctions.*;

import java.math.BigInteger;

import EulerProblems.Problem;

public class Problem65 implements Problem {

	@Override
	public String solve() {
		int converge = 100;
		int[] list = new int[converge];
		list[0]=2;
		for(int i=1;i<converge;i++){
			if(i%3==0||i%3==1){
				list[i]=1;
			}else{
				list[i]=2*(i/3+1);
			}
		}
		BigInteger num = new BigInteger("1");
		BigInteger den = new BigInteger(String.valueOf(list[converge-1]));

		for(int i=converge-2;i>=0;i--){
			BigInteger temp = new BigInteger(String.valueOf(list[i]));
			temp = temp.multiply(den);
			num = num.add(temp);
			BigInteger temp2 = den;
			den = num;
			num = temp2;
			
		}
		
		return String.valueOf(IntFunctions.countDigits(den));
	}

}
