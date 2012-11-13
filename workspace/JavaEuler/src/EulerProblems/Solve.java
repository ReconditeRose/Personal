package EulerProblems;

import eulerProblems51_100.Problem78;



/**
 * TODO Put here a description of what this class does.
 *
 * @author olsonmc.
 *         Created Jan 25, 2012.
 */
public class Solve {

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Problem Solve = new Problem78();
		System.out.println(Solve.solve());
		System.out.println(System.currentTimeMillis()-startTime+"ms");
	}

}
