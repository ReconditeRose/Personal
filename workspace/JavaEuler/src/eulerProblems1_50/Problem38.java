package eulerProblems1_50;

import EulerProblems.Problem;

public class Problem38 implements Problem {

//	private class PythTrips {
//		int[] current;
//		int generation;
//		int multi;
//
//		public PythTrips() {
//			generation = 2;
//			multi = 1;
//			current = new int[3];
//			System.out.println("sure");
//		}
//
//		int[] nextInSeries() {
//			multi += 1;
//			int[] a = new int[3];
//			for (int i = 0; i < 3; i++) {
//				a[i] = current[i] * multi;
//			}
//			return a;
//		}
//
//		int[] newSeries() {
//			generation += 1;
//			if (generation % 2 == 1) {
//				int take = (generation * generation - 1) / 2;
//				current[0] = generation;
//				current[1] = take;
//				current[2] = take + 1;
//			} else {
//				int take = (generation * generation - 1) / 4;
//				current[0] = generation;
//				current[1] = take;
//				current[2] = take + 2;
//			}
//			return current;
//		}
//
//	}

	private boolean isSquare(int i) {
		return (Math.round(Math.sqrt(i)) == Math.sqrt(i));
	}

	@Override
	public String solve() {
		int[] a = new int[1000];

		int j = 0;
		int b = 0;
		for (int i = 1; i < 1000; i++) {
			for (j = 1; j < i; j++) {
				b = i * i + j * j;
				if (isSquare(b)) {
					b = (int) Math.sqrt(b);
					if(i+j+b<1000)
					a[i + j + b] += 1;
				} else {
					b = (int) Math.sqrt(b);
				}
			}
		}

		System.out.println(isSquare(64));
		int max = 0;
		int high = 0;
		for (int i = 1; i < 1000; i++) {
			if (a[i] > max) {
				max = a[i];
				high = i;
			}
		}

		return String.valueOf(high);
	}

}
