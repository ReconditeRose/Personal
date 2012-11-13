package eulerProblems51_100;
import EulerProblems.Problem;
import eulerFunctions.Prime;
public class Problem87 implements Problem {


	int i, j, k;


	@Override
	public String solve() {
		int sum = 0;
		int total = 50000000;
		byte[] exist = new byte[total];
		i = 2;
		j = 2;
		k = 2;
		for (; i * i + j * j * j + k * k * k * k < total; i = Prime.nextPrime(i)) {
			for (; i * i + j * j * j + k * k * k * k < total; j = Prime.nextPrime(j)) {
				for (; i * i + j * j * j + k * k * k * k < total; k = Prime.nextPrime(k)) {
					int current = i * i + j * j * j + k * k * k * k;
					if (exist[current] == 0) {
						exist[current] = 1;
						sum++;
					}
				}
				k=2;
			}
			j=2;
		}
		return String.valueOf(sum);
	}
}
