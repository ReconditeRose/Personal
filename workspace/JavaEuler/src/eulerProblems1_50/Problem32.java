package eulerProblems1_50;

import java.util.Arrays;
import java.util.ArrayList;

import EulerProblems.Problem;

/**
 * TODO Put here a description of what this class does.
 *
 * @author olsonmc.
 *         Created Jan 26, 2012.
 */
public class Problem32 implements Problem {

	private boolean isPandigital(String a){
			byte[] iArray = a.getBytes();
			byte[] jArray = {'1','2','3','4','5','6','7','8','9'};
			Arrays.sort(iArray);
			return Arrays.equals(iArray,jArray);
	}
	
	@Override
	public String solve() {
		System.out.println(isPandigital("123456789"));
		ArrayList<Integer> totalInts = new ArrayList<Integer>();
		for(int i =1; i<1000;i++){
			for(int j = 1; i*j<10000;j++){
				if(isPandigital(String.format("%d%d%d",i,j,i*j))){
					if(!totalInts.contains(i*j)){
						totalInts.add(i*j);
					}
				}
			}
		}
		int total = 0;
		for(int a: totalInts){
			total+=a;
		}
		return String.valueOf(total);
	}

}
