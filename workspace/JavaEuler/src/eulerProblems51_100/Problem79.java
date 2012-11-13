package eulerProblems51_100;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import EulerProblems.Problem;

public class Problem79 implements Problem {

	public class guessArray {
		int[] guess;

		public int length() {
			return guess.length;
		}

		public guessArray(int[] first) {
			guess = first.clone();
		}

		private int reverseInt(int a) {
			if (a > 100) {
				int q = a % 10 * 100;
				q += (a / 10) % 10 * 10;
				q += (a / 100) % 10;
				return q;
			} else if (a > 10) {
				int q = a % 10 * 10;
				q += (a / 10) % 10;
				return q;
			} else {
				return a;
			}
		}

		private ArrayList<guessArray> addDigit(int position, int remaining) {
			remaining = reverseInt(remaining);
			int i = remaining % 10;
			if (remaining == 0) {
				ArrayList<guessArray> c = new ArrayList<guessArray>();
				c.add(new guessArray(guess));
				return c;
			}
			int[] newguess = new int[guess.length + 1];

			for (int j = 0; j < position; j++) {
				newguess[j] = guess[j];
			}
			newguess[position] = i;
			for (int j = position + 1; j < newguess.length; j++) {
				newguess[j] = guess[j - 1];
			}

			ArrayList<guessArray> passOn = new ArrayList<guessArray>();

			for (; position < newguess.length - 1; position++) {
				guessArray c = new guessArray(newguess);
				int temppos = position;
				if (newguess[position] == newguess[position + 1]) {
					c = new guessArray(guess);
					temppos = position;
				} else {
					if (position > 0) {
						if (newguess[position] == newguess[position - 1]) {
							c = new guessArray(guess);
							temppos = position - 1;
						}
					}
				}
				passOn.addAll(c.addDigit(temppos + 1, (remaining - i) / 10));
				newguess[position] = newguess[position + 1];
				newguess[position + 1] = i;
			}
			guessArray c = new guessArray(newguess);
			int temppos = position;
			if (position > 0) {
				if (newguess[position] == newguess[position - 1]) {
					c = new guessArray(guess);
					temppos = position - 1;
				}
			}
			passOn.addAll(c.addDigit(temppos + 1, (remaining - i) / 10));

			return passOn;
		}

		public boolean equals(guessArray a) {
			return a.toString().equals(this.toString());
		}

		public String toString() {
			String a = "";
			for (int i = 0; i < guess.length; i++) {
				a = a + String.valueOf(guess[i]);
			}
			return a;
		}
	}

	private ArrayList<guessArray> removeLongest(ArrayList<guessArray> a) {
		int longest = 50;
		for (guessArray b : a) {
			if (b.length() < longest) {
				longest = b.length();
			}
		}
		ArrayList<guessArray> newArray = new ArrayList<guessArray>();
		for (int i = 0; i < a.size(); i++) {
			guessArray b = a.get(i);
			if (b.length() == longest) {
				if (i == a.size() - 1) {
					newArray.add(b);
				} else {

					if (!b.equals(a.get(i + 1))) {
						newArray.add(b);
					}
				}
			}
		}
		return newArray;
	}

	@Override
	public String solve() {
		ArrayList<guessArray> a = new ArrayList<guessArray>();
		int[] start = { 3, 1, 9 };
		a.add(new guessArray(start));

		File aFile = new File("src//EulerProblems//combinations.txt");
		ArrayList<String> strings = new ArrayList<String>();

		try {
			Scanner inScanner = new Scanner(aFile);
			while (inScanner.hasNext()) {
				ArrayList<guessArray> c = new ArrayList<guessArray>();
				int compare = Integer.valueOf(inScanner.next());
				for (guessArray b : a) {
					c.addAll(b.addDigit(0, compare));
				}
				c = removeLongest(c);
				a = c;
				System.out.println(compare);
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}

		for (guessArray d : a) {
			System.out.println(d);
		}
		return null;
	}
}
