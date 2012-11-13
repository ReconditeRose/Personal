package eulerProblems51_100;

import EulerProblems.Problem;

public class Problem66 implements Problem {
	private boolean isSquare(long i) {
		if (i % 4 == 2 || i % 4 == 3) {
			return false;
		}
		long p = (long)( Math.sqrt(i)+0.5);
		
		return (p*p == i);
	}

	@Override
	public String solve() {
		int end = 1000;
		long max = 0;
		long maxHold = 0;
		for (int i = 1; i <= end; i++) {
			if (isSquare(i))
				continue;
			for (long x = 1;; x += 1) {
				long j = x;
				j *= x;
				j*=i;
				j += 1;
				if (isSquare(j)) {
					j = (long) Math.sqrt(j);
					System.out.println(j + "^2-" + i + "x" + x + "^2 = 1");
					if (j > max) {
						max = j;
						maxHold = i;
					}
					break;
				}
			}
		}
		return String.valueOf(maxHold);
	}

}
