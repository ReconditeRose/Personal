package eulerProblems51_100;
import EulerProblems.Problem;
import eulerFunctions.Prime;
public class Problem72 implements Problem{
	static final int finalNum = 10000;
	@Override
	public String solve() {
		int sum = 0;
		for(int den =2; den <= finalNum; den++){
			sum++;
			for(int num = 2; num< den;num++){
				if(den%num==0){
					 continue;
				}
				if(Prime.GCD(num, den)==1){
					sum++;
				}

			}
		}
		return String.valueOf(sum);
	}

}
