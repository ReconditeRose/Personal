package eulerProblems51_100;
import EulerProblems.Problem;
import eulerFunctions.Prime;

public class Problem58 implements Problem {

	@Override
	public String solve() {
		int sideL = 1;
		int base = 1;
		
		int primes = 0;
		int total = 1;
		
		double ratio = 1;
		while(ratio >0.1){
			for(int i =0;i<4;i++){
				base+=sideL+1;
				total+=1;
				if(Prime.isPrime(base)){
					primes+=1;
				}
			}
			ratio = (double) primes/total;
			sideL+=2;
		}
		
		return String.valueOf(sideL);
	}

}
