package eulerProblems51_100;

import EulerProblems.Problem;

public class Problem78 implements Problem {

	public long distinctBins(int j) {
		// holdData[total][nextDigit]
		long[][] holdData = new long[j + 1][j + 1];
		for (int i = 1; i < j + 1; i++) {
			holdData[i][1] = 1;
		}
		long sum;
		for (int i = 2; i < j + 1; i++) {
			sum = 1;
			for (int k = 1; k < i; k++) {
				if(k==1){
					sum+=1;
				} else {
					if (i>k*2) {
						sum += holdData[i - k][k];
						holdData[i][k] = holdData[i - k][k]+1;
					} else {
						sum += holdData[i-k][i-k];
						holdData[i][k] = holdData[i -k][i-k]+1;
					}
				}
			}
			holdData[i][i] = sum;
			if(holdData[i][i]%1000000==0){
				return holdData[i][i];
			}
		}
		return holdData[j][j];
	}
	
	public long searchForBinTotal(long divisible){
		int total = 1;
		long sum=1;
		final long divide = divisible;
		long[] lastHold = new long[total];
		long[] straight = new long[total];
		lastHold[0]=1;
		straight[0]=1;
		long[] temp,tempstraight;
		while(sum%divide != 0){
			total++;
			temp = new long[total];
			tempstraight = new long[total];
			sum=1;

			for(int i=1;i<total-1;i++){
				if(total>2*i){
					sum+=lastHold[total-i-1];
					temp[i-1]=lastHold[total-i-1]+1;
				}else{
					sum+=straight[total-i];
					temp[i-1]=straight[total-i]+1;
				}
				System.out.println(temp[i-1]+" "+i);
			}
			lastHold = temp;
			for(int i=0;i<total-1;i++){
				tempstraight[i]=straight[i];

			}
			temp[total-1]=1;
			tempstraight[total-1]=sum;
			straight= tempstraight;
			System.out.println("Sum:"+sum+" with total "+(total-1));
		}
		return total;
	}

	@Override
	public String solve() {
		for (int i = 1; i < 15; i++) {
			 System.out.println(distinctBins(i)+" "+i);
		}
//		return (searchForBinTotal(11) + "");
		return (distinctBins(7) + "");
	}

}
