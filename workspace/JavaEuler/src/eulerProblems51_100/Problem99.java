package eulerProblems51_100;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import EulerProblems.Problem;

public class Problem99 implements Problem {

	@Override
	public String solve() {
		double currentMax = 0;
		int k = 1;
		int lineNumber = 0;
		File aFile = new File("src//EulerProblems//base_exp.txt");
		
		try {
			Scanner inScanner = new Scanner(aFile);
			double a = 0;
			while (inScanner.hasNextLine()) {
				Scanner c = new Scanner(inScanner.nextLine());
				c.useDelimiter(",");
				
				a = Math.log(Double.valueOf(c.next()));
				a*= (Double.valueOf(c.next()));
				if(a>currentMax){
					lineNumber = k;
					currentMax = a;
				}
				k++;
				
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		
		return (lineNumber+"");
	}

}
