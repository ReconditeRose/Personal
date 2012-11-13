package eulerProblems51_100;
import EulerProblems.Problem;
import eulerFunctions.*;

public class Problem62 implements Problem {
	static final int max = 100000;
	static final int goala = 4;

	@Override
	public String solve() {
		int[] goal = new int[max + 1];
		long aHigh = 10;
		long high = 1000;
		long a, b;
		a=0;
		for (int i = 9; i < max; i++) {
			int current = 0;
			for (int j = i + 1; j < aHigh; j++) {
				a = (long) i;
				b = (long) j;
				a *= a * a;
				b *= b * b;

				if (IntFunctions.isPermutation(a, b)) {
					System.out.println(i +" matched with "+j);
					current++;}
				}
			if (current == goala) {
				return (String.valueOf(a));
			

			}
			if (i == aHigh) {
				high *= 10;
				while (aHigh * aHigh * aHigh < high) {
					aHigh++;
				}
			}
		}

		return null;
	}

}
