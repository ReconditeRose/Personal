
public class ArrayGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Prime.GCD(3, 7));
		int[][] Solution = {{1,1,1,0},{1,0,1,0},{1,0,1,0},{1,1,1,1}};
		TileSolver a = new TileSolver(Solution);
		int[][] solution = a.solve();
		for(int i =0;i<solution.length;i++){
			for(int j = 0;j<solution[0].length;j++){
				System.out.print(solution[i][j]);
			}
			System.out.println();
		}
	}

}
