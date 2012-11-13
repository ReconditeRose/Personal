package eulerProblems1_50;

import EulerProblems.Problem;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author olsonmc. Created Feb 21, 2012.
 */
public class Problem31 implements Problem {

	private static final int[] combinations = { 1, 2, 5, 10, 20, 50, 100, 200,500 };

	@Override
	public String solve() {
		return ("" + lessThen(200,200));
	}

	private int lessThen(int sum, int maximum) {
		if (sum == 0) {
			return 1;
		} else {
			int tempsum = 0;
			for (int i = 0; combinations[i] <= sum && combinations[i] <= maximum; i++) {
				tempsum += lessThen(sum - combinations[i],combinations[i]);
			}
			return tempsum;
		}
	}
}
