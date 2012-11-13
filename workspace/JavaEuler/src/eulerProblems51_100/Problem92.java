package eulerProblems51_100;

import EulerProblems.Problem;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author olsonmc. Created Jan 26, 2012.
 */
public class Problem92 implements Problem {

	private int returnSquares(int b) {
		int total = 0;
		String aString = String.valueOf(b);
		for (int i = 0; i < aString.length(); i++) {
			total += Math.pow(Integer.parseInt(aString.substring(i, i + 1)), 2);
		}
		return total;
	}

	@Override
	public String solve() {
		int[] results = new int[10000000];
		int total89 = 0;
		for (int i = 1; i < 10000000; i++) {
			int b = i;
			while (results[i] == 0) {
				if (b == 89) {
					results[i] = 89;
					total89++;
					break;
				}
				if (b == 1) {
					results[i] = 1;
					break;
				}
				if (results[b] == 0) {
					b = returnSquares(b);
				} else {
					b = results[b];
				}

			}
		}
		return String.valueOf(total89);
	}
}
