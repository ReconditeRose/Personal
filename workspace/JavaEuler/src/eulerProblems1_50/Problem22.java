package eulerProblems1_50;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import EulerProblems.Problem;

/**
 * Counts the name score of each name in the list
 * 
 * @author olsonmc. Created Feb 21, 2012.
 */
public class Problem22 implements Problem {

	@Override
	public String solve() {
		int total = 0;
		File aFile = new File("src//EulerProblems//names.txt");
		ArrayList<String> strings = new ArrayList<String>();
		
		try {
			Scanner inScanner = new Scanner(aFile);
			inScanner.useDelimiter("\",\"");
			while (inScanner.hasNext()) {
				strings.add(removeOdd(inScanner.next()));
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		Collections.sort(strings);
		for(int i =0;i<strings.size();i++){
			total+= nameScore(strings.get(i))*(i+1);
		}
		return (""+total);
	}
	
	private int nameScore(String s){
		int wordScore = 0;
		for(int i = 0;i<s.length();i++){
			wordScore += Character.getNumericValue(s.charAt(i))-9;
		}
				
		return wordScore;
	}
	private String removeOdd(String s){
		String newString = new String();
		for(int i = 0;i<s.length();i++){
			if(s.charAt(i) != '\"'){
				newString += s.charAt(i);
			}
		}
		return newString;
	}
}
