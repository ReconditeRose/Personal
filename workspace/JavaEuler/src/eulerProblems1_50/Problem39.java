package eulerProblems1_50;

import java.util.Arrays;

import EulerProblems.Problem;

public class Problem39 implements Problem {

	private boolean isPandigital(String a) {
		byte[] iArray = a.getBytes();
		byte[] jArray = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		Arrays.sort(iArray);
		return Arrays.equals(iArray, jArray);
	}

	@Override
	public String solve() {
		int max = 0;

		for (int j = 25; j < 33; j++) {
			String a = "";
			for (int i = 1; i <= 4; i++) {
				a = String.format(a + "%d", i * j);
			}
			if(isPandigital(a)){
				int c= Integer.valueOf(a);
				if(c>max){
					max=c;
				}
			}
		}

		for (int j = 100; j < 333; j++) {
			String a = "";
			for (int i = 1; i <= 3; i++) {
				a = String.format(a + "%d", i * j);
			}
			if(isPandigital(a)){
				int c= Integer.valueOf(a);
				
				if(c>max){
					max=c;
				}
			}
		}

		for (int j = 5000; j <= 10000; j++) {
			String a = "";
			for (int i = 1; i <=2 ; i++) {
				a = String.format(a + "%d", i * j);
			}
			if(isPandigital(a)){
				int c= Integer.valueOf(a);
				if(c>max){
					max=c;
				}
			}
		}
		return String.valueOf(max);
	}

}
