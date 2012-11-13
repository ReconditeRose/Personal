package EulerProblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Roman implements Problem{

	
private int containsString(String look){
	int sum = 0;
	while(look.contains("IIIII")){
		look=look.replace("IIIII", "V");
		sum+=4;
	}
	
	if(look.contains("IIII")){
		look=look.replace("IIII", "IV");
		sum+=2;
	}
	if(look.contains("VIV")){
		look=look.replace("VIV", "IX");
		sum+=1;
	}
	if(look.contains("VV")){
		look=look.replace("VV", "X");
		sum+=1;
	}
	
	while(look.contains("XXXXX")){
		look=look.replace("XXXXX", "L");
		sum+=4;
	}
	
	if(look.contains("XXXX")){
		look=look.replace("XXXX", "XL");
		sum+=2;
	}
	if(look.contains("LXL")){
		look=look.replace("LXL", "XC");
		sum+=1;
	}
	if(look.contains("LL")){
		look=look.replace("LL", "C");
		sum+=1;
	}
	
	while(look.contains("CCCCC")){
		look=look.replace("CCCCC", "D");
		sum+=4;
	}
	
	if(look.contains("CCCC")){
		look=look.replace("CCCC", "CD");
		sum+=2;
	}
	if(look.contains("DCD")){
		look=look.replace("DCD", "CM");
		sum+=1;
	}
	if(look.contains("DD")){
		look=look.replace("DD", "M");
		sum+=1;
	}
	System.out.println(look);
	return sum;
}

	@Override
	public String solve() {
		File aFile = new File("src//EulerProblems//Roman.txt");
		int sum = 0;
		try {
			Scanner inScanner = new Scanner(aFile);
			while (inScanner.hasNext()) {
				sum += containsString(inScanner.next());
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		return (""+sum);
	}

	
}
