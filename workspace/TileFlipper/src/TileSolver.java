//TODO Add a rational class that includes into the rref solver
public class TileSolver {
	private int[] array;
	private int width;
	private int height;
	matrix solution;
	boolean flipper = false;

	
	private int[][] generateArray(int width, int height) {
		int total = width *height;
		int[][] array = new int[total][total];
		
		for(int i1 = 0; i1<total;i1++){
			for(int i2 = 0; i2<total;i2++){
				array[i1][i2] = 0;
			}
		}
		for(int k = 0;k<total;k++){
			int i = k%width;
			int j = width*(k/width);
			array[k][i+j]=1;
			if(i>0){
				array[k][i-1+j]=1;
			}
			if(i<width-1){
				array[k][i+1+j]=1;
			}
			if(j+i+width < total){
				array[k][j+i+width] = 1;
			}
			if(j+i-width>= 0){
				array[k][j+i-width] = 1;
			}
		}
		return array;
	}

	public TileSolver(int[] array, int width, int height) {
		this.array = array;
		this.width= width;
		this.height = height;
		int[][] solveArray = new int[width*height][width*height+1];
		int[][] baseArray = generateArray(width,height);
		
		for(int i = 0;i<width*height;i++){
			for(int j = 0;j<width*height;j++){
				solveArray[i][j] = baseArray[i][j];
			}
			solveArray[i][width*height] = array[i];
		}
		solution = new matrix(solveArray);
	}
	
	public TileSolver(int[][] array) {
		this.height = array.length;
		this.width = array[0].length;
		int[] bar = new int[width*height];
		for(int i =0;i<height;i++){
			for(int j =0; j<width;j++){
				bar[width*i+j] = array[i][j];
			}
		}
		this.array = bar;
		int[][] solveArray = new int[width*height][width*height+1];
		int[][] baseArray = generateArray(width,height);
		
		for(int i = 0;i<width*height;i++){
			for(int j = 0;j<width*height;j++){
				solveArray[i][j] = baseArray[i][j];
			}
			solveArray[i][width*height] = this.array[i];
		}
		solution = new matrix(solveArray);
	}

	public int[][] solve() {
		solution.toRREF();
		int[][] returnSolution = new int[height][width];
		int[] newArray = solution.returnSolutionRow();
		
		for(int i =0;i<height;i++){
			for(int j =0; j<width;j++){
				returnSolution[i][j]=newArray[j+i*width];
				if(returnSolution[i][j]<0)
					returnSolution[i][j]*= -1;
				returnSolution[i][j] = returnSolution[i][j] %2;
			}
		}
		return returnSolution;
		
	}

}