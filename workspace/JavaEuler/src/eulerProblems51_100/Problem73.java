package eulerProblems51_100;
import EulerProblems.Problem;
import eulerFunctions.Prime;
public class Problem73 implements Problem {
	final static long finalNum = 12000;

	@Override
	public String solve() {
		int sum = 0;
//		for (long j = 5; j <= finalNum; j++) {
//			sum += (int) (Math.ceil(j / 2.0) - Math.ceil(j / 3.0));
//			System.out.print(sum);
//			if (j%3==0){
//				sum -= 1;
//			}
//			System.out.println("   " + sum);
//		}
//		System.out.println();
//		rational low = new rational(1,3);
//		rational high = new rational(1,2);
//		rational compare;
//		
//		for (int j = 5; j <= finalNum; j++) {
//			compare = new rational(1,j);
//			sum+=compare.numbersBetween(low, high);
//			System.out.println(sum);
//		}

		for(int den =5; den <= finalNum; den++){
			for(int num = den/3 + 1; num< (den-1)/2+1;num++){
				if(Prime.GCD(num, den)==1){
					sum++;
				}
			}
		}
		
		return String.valueOf(sum);
	}

}
