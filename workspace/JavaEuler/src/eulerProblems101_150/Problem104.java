package eulerProblems101_150;
import eulerFunctions.BigIntegerFunctions;

import java.math.BigInteger;

import EulerProblems.Problem;

public class Problem104 implements Problem {

	@Override
	public String solve() {
		BigInteger a, b, c;
		a = new BigInteger("1");
		b = new BigInteger("1");
		for (int count = 3;; count++) {
			c = a;
			a = a.add(b);
			b = c;
			if (count < 250) {
				continue;
			}
			if(count==541)
				System.out.println(a.toString());
			if (BigIntegerFunctions.backPanDigital(a)) {
				System.out.println(count + " is back ");
			}
			if (BigIntegerFunctions.frontPanDigital(a)) {
				System.out.println(count + " is front");
			}

			if (BigIntegerFunctions.bothPanDigital(a)) {
				return (count + "");
			}
		}
	}

}
