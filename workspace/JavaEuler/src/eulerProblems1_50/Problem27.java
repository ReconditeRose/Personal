package eulerProblems1_50;

import EulerProblems.Problem;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author olsonmc. Created Jan 25, 2012.
 */
public class Problem27 implements Problem {

	private boolean isPrime(int a) {
		if(a==2){
			return true;
		}
		if(a<=1 || a %2 ==0){
			return false;
		}
		for (int j = 3; j*j <= a ; j += 2) {
			if (a % j == 0) {
				return false;
			}
		}
		return true;
	}

	private int countPrimes(int a,int b){
		int total = 0;
		boolean cont = true;
		
		for(int n = 0;cont == true;n++){
			if(isPrime(n*n + a*n + b)){
				total++;
			}else{
				cont = false;
			}
		}
		return total;
	}
	@Override
	public String solve() {
		
		
		int higha = 0, highb = 0, highTotal = 0;
		for (int a = -1000; a < 1000; a++) {
			for (int b = 2; b < 1000; b++) {
				int tempTotal = countPrimes(a,b);
				if(tempTotal> highTotal){
					higha = a;
					highb = b;
					highTotal = tempTotal;


				}
			}
		}
		return(String.format("%d",higha*highb));
	}

}
