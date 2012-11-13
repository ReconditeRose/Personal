package eulerFunctions;



import java.util.ArrayList;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author olsonmc. Created Jan 25, 2012.
 */
public class Prime {
	static public int nextPrime(int current){
		if(current==2){
			return 3;
		}
		current+=2;
		while(!isPrime(current)){
			current+=2;
		}
		return current;
	}
	static public boolean isPrime(int a) {
		if (a == 2) {
			return true;
		}
		if (a <= 1 || a % 2 == 0) {
			return false;
		}
		for (int j = 3; j * j <= a; j += 2) {
			if (a % j == 0) {
				return false;
			}
		}
		return true;
	}

	static public ArrayList<Integer> primeDivisors(int a) {
		ArrayList<Integer> list = new ArrayList<Integer>();
			while (a == 2 || a % 2 == 0) {
				list.add(2);
				a /= 2;
			}
			for (int j = 3; j * j <= a; j += 2) {
				while (a % j == 0) {
					list.add(j);
					a /= j;
				}
			}
			list.add(a);
		return list;

	}

	static public int GCD(int a, int b) {
		if (b==0) return a;
		   return GCD(b,a%b);
	}
}
