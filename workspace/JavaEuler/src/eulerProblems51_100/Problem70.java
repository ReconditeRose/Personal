package eulerProblems51_100;
import EulerProblems.Problem;
import eulerFunctions.*;

public class Problem70 implements Problem {

	final static int topNum = 10000000;



	@Override
	public String solve() {
		int[] a = new int[topNum + 1];
		boolean[] valid = new boolean[topNum + 1];
		for (int i = 1; i < topNum; i++) {
			a[i] = i;
			valid[i] = true;
		}

		for (int j = 2; j < topNum; j++) {
			if (a[j] == j) {
				for (int k = j; k < topNum; k += j) {
					if (valid[k] == true) {
						a[k] = a[k] / j * (j - 1);
						if (IntFunctions.getLength(a[k]) < IntFunctions
								.getLength(k)) {
							valid[k] = false;
						}
					}
				}
			}
		}
		int max = 1;
		double minimum =0;
		double tempMin = 0;
		for (int j = 2; j < topNum; j++) {
			if(valid[j]){
				tempMin = ((double) j)/a[j];
				if( tempMin <minimum || minimum == 0){
					if(IntFunctions.isPermutation(j,a[j])){
					minimum = 	tempMin;
					max = j;
					System.out.println(j+" and "+a[j]);
					}
				}
			}
		}

		// TODO Auto-generated method stub
		return null;
	}

}
