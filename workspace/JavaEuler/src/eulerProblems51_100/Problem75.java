package eulerProblems51_100;
import EulerProblems.Problem;
import eulerFunctions.Prime;
public class Problem75 implements Problem {
	 final static int goal = 1500000;
	//final static int goal = 1500;

	@Override
	public String solve() {
		int[] total = new int[goal + 1];
		int point = 0;
		for (int i = 2; i * i < goal; i++) {
			for (int j = 1; j < i; j++) {
				if((i+j)%2==1)
				if (Prime.GCD(i, j) == 1) {
					point = 2 * i * i + 2 * i * j;
					for (int casc = 1; point*casc < goal; casc += 1) {
						total[point * casc] += 1;
//						System.out.println(i * i - j * j+ " " + 2 * i
//								* j + " " + (i * i + j * j));
					}
				}
			}
		}

		int sum = 0;
		System.out.println(total[48]);
		for (int i = 1; i <= goal; i++) {
			if (total[i] == 1)
				sum++;
		}
		return ("" + sum);
	}

}
