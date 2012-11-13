package eulerProblems51_100;

import EulerProblems.Problem;

public class Problem76 implements Problem {

	
	@Override
	public String solve() {
		return ("" + (lessThen(100,100)-1));
	}

	private int lessThen(int sum, int maximum) {
		if (sum == 0) {
			return 1;
		} else {
			int tempsum = 0;
			for (int i = 1; i <= sum && i <= maximum; i++) {
				tempsum += lessThen(sum - i,i);
			}
			return tempsum;
		}
	}


}
