package EulerProblems;

public class SudokuSolver {

	private int[][] grid;
	private int[][][] cons;
	private int dimension;
	private int sqrdim;
	private int unsolve;

	public String toString() {
		String A = "";
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				A = A + grid[i][j];
			}
			A = A + "\n";
		}
		return A;
	}

	public SudokuSolver(int[][] sudoku) {

		this.grid = sudoku;
		this.dimension = this.grid.length;
		this.unsolve = dimension * dimension;
		cons = new int[dimension][dimension][dimension];
		this.sqrdim = (int) Math.sqrt(dimension);
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				for (int k = 0; k < dimension; k++) {
					cons[i][j][k] = 1;
				}
			}
		}
	}

	public boolean solve() {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (grid[i][j] != 0)
					cellSolved(i, j, grid[i][j]);
			}
		}
		while (unsolve > 0) {
			if (checkConditions() == false) {
				return false;
			}
			boolean progress = false;
			for (int num = 1; num <= dimension; num++) {

				// Check Unique
				for (int i = 0; i < dimension; i++) {
					for (int j = 0; j < dimension; j++) {
						if (grid[i][j] != 0)
							break;
						int count = 0;
						int lastNum = 0;
						for (int k = 1; k <= dimension; k++) {
							if (cons[i][j][k - 1] == 1) {
								count++;
								lastNum = k;
							}
						}
						if (count == 1) {
							cellSolved(i, j, lastNum);
							progress = true;
						}
					}
				}

				// Check row
				for (int i = 0; i < dimension; i++) {

					int count = 0;
					int lastNum = 0;

					for (int k = 0; k < dimension; k++) {
						if (cons[k][i][num - 1] == 1) {
							count++;
							lastNum = k;
						}
					}
					if (count == 1) {
						cellSolved(lastNum, i, num);
						progress = true;
					}
				}
				// Check column
				for (int i = 0; i < dimension; i++) {

					int count = 0;
					int lastNum = 0;

					for (int k = 0; k < dimension; k++) {
						if (cons[i][k][num - 1] == 1) {
							count++;
							lastNum = k;
						}
					}
					if (count == 1) {
						cellSolved(i, lastNum, num);
						progress = true;
					}
				}
				// Check block
				for (int i = 0; i < this.sqrdim; i++) {
					for (int j = 0; j < this.sqrdim; j++) {
						int basex = i;
						int basey = j;
						int count = 0;
						int posx = 0;
						int posy = 0;

						for (int k = 0; k < this.sqrdim; k++) {
							for (int l = 0; l < this.sqrdim; l++) {
								if (cons[k + sqrdim * basex][l + sqrdim * basey][num - 1] == 1) {
									count++;
									posx = k + sqrdim * basex;
									posy = l + sqrdim * basey;
								}
							}
						}
						if (count == 1) {
							cellSolved(posx, posy, num);
							progress = true;
						}

					}
				}
			}
			if (progress == false) {
				for (int i = 0; i < dimension; i++) {
					for (int j = 0; j < dimension; j++) {
						if (grid[i][j] == 0) {
							for (int k = 1; k <= dimension; k++) {
								if (cons[i][j][k - 1] == 1) {
									int[][] temp = new int[9][9];
									for (int i1 = 0; i1 < dimension; i1++) {
										for (int j1 = 0; j1 < dimension; j1++) {
											temp[i1][j1] = grid[i1][j1];
										}
									}
									temp[i][j] = k;
									SudokuSolver a = new SudokuSolver(temp);
									if (a.solve()) {
										this.grid = a.getGrid();
										return true;
									}

								}
							}
						}
					}
				}
				return false;
			}
			
		}
		return true;
	}

	private void clearRow(int row, int num, int exclude) {
		for (int i = 0; i < dimension; i++) {
			if (i < exclude * sqrdim || i >= (exclude + 1) * sqrdim)
				cons[row][i][num - 1] = 0;
		}
	}

	private void clearColumn(int column, int num, int exclude) {
		for (int i = 0; i < dimension; i++) {
			if (i < exclude * sqrdim || i >= (exclude + 1) * sqrdim)
				cons[i][column][num - 1] = 0;
		}
	}

	public void cellSolved(int row, int column, int num) {
		grid[row][column] = num;
		clearColumn(column, num, -1);
		clearRow(row, num, -1);
		int basex = row / this.sqrdim;
		int basey = column / this.sqrdim;
		unsolve -= 1;
		// System.out.println(unsolve);

		for (int i = 0; i < dimension; i++) {
			cons[row][column][i] = 0;
		}

		for (int i = 0; i < this.sqrdim; i++) {
			for (int j = 0; j < this.sqrdim; j++) {
				cons[i + basex * sqrdim][j + basey * sqrdim][num - 1] = 0;

			}
		}
	}

	private boolean checkConditions() {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				int count = 0;
				if (grid[i][j] == 0) {
					for (int k = 0; k < dimension; k++) {
						if (cons[i][j][k] == 1)
							count++;
					}
					if (count == 0)
						return false;
				}
			}
		}


		for (int num = 1; num <= dimension; num++) {

			// Check Conditions of simplification
			for (int i = 0; i < this.sqrdim; i++) {
				for (int j = 0; j < this.sqrdim; j++) {
					int basex = i;
					int basey = j;
					int posx = -1;
					int posy = -1;
					int count = 0;

					boolean oneRow = false;
					boolean oneColumn = false;

					for (int k = 0; k < this.sqrdim; k++) {
						for (int l = 0; l < this.sqrdim; l++) {
							if (cons[k + sqrdim * basex][l + sqrdim * basey][num - 1] == 1) {
								count++;
								if (posx == -1 && posy == -1) {
									oneRow = true;
									oneColumn = true;
								} else {
									if (posx != k + sqrdim * basex) {
										oneColumn = false;
									}
									if (posy != l + sqrdim * basey) {
										oneRow = false;
									}

								}
								posx = k + sqrdim * basex;
								posy = l + sqrdim * basey;
							}
						}
					}
					if (count > 1) {
						if (oneColumn == true) {
							clearRow(posx, num, j);
						}

						if (oneRow == true) {
							clearColumn(posy, num, i);
						}
					}
				}
			}
		}
		return true;
	}

	public void setGrid(int[][] a) {
		this.grid = a;
	}

	public int[][] getGrid() {
		return this.grid;
	}

}