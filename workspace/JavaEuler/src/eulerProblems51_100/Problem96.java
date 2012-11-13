package eulerProblems51_100;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import EulerProblems.Problem;
import EulerProblems.SudokuSolver;

public class Problem96 implements Problem{

	private static int[][] toSudoku(ArrayList<String> a) {
		int[][] b = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				b[i][j] = a.get(i).charAt(j);
				b[i][j] = Character.digit(a.get(i).charAt(j), 10);
			}
		}

		return b;
	}

	@Override
	public String solve() {
		int sum =0;
		File aFile = new File("src//EulerProblems//sudoku.txt");
		
		try {
			Scanner inScanner = new Scanner(aFile);
			while (inScanner.hasNextLine()) {
				
				if (inScanner.hasNextLine())
					System.out.println(inScanner.nextLine());
				ArrayList<String> sudokuA = new ArrayList<String>();
				for (int i = 0; i < 9; i++) {
					if (inScanner.hasNextLine()) {
						sudokuA.add(inScanner.nextLine());
					}
				}
				SudokuSolver a1 = new SudokuSolver(toSudoku(sudokuA));
				a1.solve();
				int [][] tempt = a1.getGrid();
				sum+= tempt[0][0]*100+tempt[0][1]*10+tempt[0][2];
				
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		return String.valueOf(sum);
	}

}