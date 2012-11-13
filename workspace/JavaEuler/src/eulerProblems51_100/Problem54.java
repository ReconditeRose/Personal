package eulerProblems51_100;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.*;

import EulerProblems.Problem;

public class Problem54 implements Problem{
	
	private class cardCompare implements Comparator<String>{

		@Override
		public int compare(String arg0, String arg1) {
			return cardValue(arg0) - cardValue(arg1);
		}
		
	}
	private int cardValue(String a){
		char[] compareArray = {'T','J','Q','K','A'};
		char a1 = ((String) a).charAt(0);
		int a2;
		a2 = 0;
		for(int i =0;i<5;i++){
			if(compareArray[0]==a1){
				a2 = i+10;
			}
		}
		if(a2 == 0){
			a2= (int) (a1);
		}
		return a2;
	}
	
	private boolean Straight(ArrayList<String> a){
		for(int i =0; i <a.size()-2;i++){
			if(cardValue(a.get(i)) -cardValue(a.get(i-1))!=1){
				return false;
			}
		}
		return true;
	}

	@Override
	public String solve() {
		File aFile = new File("src//EulerProblems//poker.txt");
		ArrayList<String> strings = new ArrayList<String>();
		int totalPlayer = 0;
		try {
			Scanner inScanner = new Scanner(aFile);
			while (inScanner.hasNextLine()) {
				if(testHand(inScanner.nextLine())==1){
					totalPlayer+=1;
				}
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		return String.valueOf(totalPlayer);
	}
	
	private int testHand(String combine){
		ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
		for(int i=0;i<2;i++){
			a.add(new ArrayList<String>());
		}
		Pattern p = Pattern.compile("[A-Z0-9]");
		Matcher c = p.matcher(combine);
		int counter =0;
		int i = 0;
		while(c.find()){
			ArrayList<String> temp = a.get(counter);
			temp.add(c.group());
			i++;
			if(i==5){
				counter++;
				i=0;
			}
		}
		cardCompare  comper = new cardCompare();
		int[] flush = new int[a.size()];
		int[] straight = new int[a.size()];
		
		for(i =0; i<a.size();i++){
			ArrayList<String> comp = a.get(i);
			Collections.sort(comp, comper);
			if(Straight(comp) == true){
				straight[i] = 1;
			}else{
				straight[i] = 0;
			}
			char color1 = comp.get(0).charAt(1);
			flush[i] =1;
			for(String test: comp){
				if(test.charAt(1)!=color1){
					flush[i] = 0;
				}
			}
		}
		//TODO add in checking of variables
		
		return 1;
	}

}
