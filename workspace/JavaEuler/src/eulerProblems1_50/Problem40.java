package eulerProblems1_50;

import EulerProblems.Problem;

/**
 * TODO Put here a description of what this class does.
 *
 * @author olsonmc.
 *         Created Jan 31, 2012.
 */
public class Problem40 implements Problem{

	@Override
	public String solve() {
		int product = 1;
		int start =1;
		int sumParts = 1;
		for(int hitValue =10; hitValue < 1000001;){
			start+=1;
			sumParts += String.valueOf(start).length();
			if(sumParts>=hitValue){
				char a = String.valueOf(start).charAt(String.valueOf(start).length()-1-sumParts+hitValue);
				product*=Character.getNumericValue(a);
				hitValue*=10;
			}
			
		}
		return String.valueOf(product);
	}

}
