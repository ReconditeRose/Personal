package eulerProblems51_100;
import EulerProblems.Problem;
import eulerFunctions.*;

public class Problem86 implements Problem {
	static final int max = 1000000;

	@Override
	public String solve() {
		long i = 1, j = 1, k = 1;
		for (long sum = 0; sum < max;) {
			for (j = 1; j <= k; j++) {
				for (i = 1; i <= j; i++) {
					if (IntFunctions.isSquare((i + j) * (i + j) + k * k) == true) {
							sum += 1;
					}
				}
			}
			System.out.println("dim:" + k + " with total:" + sum);
			k++;
		}

		return String.valueOf(k);
	}

}
