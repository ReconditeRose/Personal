package eulerProblems51_100;

import EulerProblems.Problem;
import eulerFunctions.*;

public class Problem94 implements Problem {

	@Override
	public String solve() {
		long sum = 0;
		long b = 3;
		long a = 1;
		long endGoal = 1000000000;
		for(;b+b+a<endGoal;b+=2){
			a=b-1;
			if(IntFunctions.isSquare(b*b-a*a/4)){
				sum+=2*b+a;
				System.out.println(a);
			}
			a=b+1;
			if(IntFunctions.isSquare(b*b-a*a/4)){
				sum+=2*b+a;
				System.out.println(a);
			}
			a+=2;
		}
		return String.valueOf(sum);
	}

}
