package eulerProblems51_100;

import EulerProblems.Problem;

public class Problem69 implements Problem {
	final static int topNum = 1000000;

	@Override
	public String solve() {
		int[] a = new int[topNum + 1];
		for (int i = 1; i < topNum; i++) {
			a[i] = i;
		}
		for (int j = 2; j < topNum; j++) {
			if (a[j] == j) {
				for (int k = j; k < topNum; k += j) {

					a[k] = a[k] / j * (j - 1);
				}
			}
		}
		
		double max = 1;
		int high = 1;
		for (int j = 2; j < topNum; j++) {
			if (j / ((double) a[j]) > max) {
				max = j / ((double) a[j]);
				high = j;
			}
		}

		return String.valueOf(high);
	}

}
