package eulerProblems51_100;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import EulerProblems.Problem;

public class Problem83 implements Problem {

	class node {
		private int x;
		private int y;
		private int[][] grid;
		private int[][] move;
		private ArrayList<node> updateList;
		int sum;
		boolean update;

		public node(int x, int y, int[][] grid, int[][] move,ArrayList<node> updateList,int current){
			this.x = x;
			this.y= y;
			this.grid = grid;
			this.move = move;
			this.updateList = updateList;
			this.sum = grid[x][y]+current;
			update = false;
			if(move[x][y]==0 || sum<move[x][y]){
				update = true;
				move[x][y]= this.sum;
				
			}
			
		}
		private void move(){
			if(update && this.sum== move[x][y]){
			CheckDown();
			CheckRight();
			CheckLeft();
			CheckUp();
			}
			updateList.remove(this);
		}
		private void CheckDown(){
			if(y<(this.grid.length-1)){
			int cx = x;
			int cy = y+1;
				updateList.add(new node(cx,cy,grid,move,updateList,sum));
			
			}
		}
		private void CheckRight(){
			if(x<(this.grid.length-1)){
			int cx = x+1;
			int cy = y;
			updateList.add(new node(cx,cy,grid,move,updateList,sum));
			}
		}
		
		private void CheckUp(){
			if(y>0){
			int cx = x;
			int cy = y-1;
				updateList.add(new node(cx,cy,grid,move,updateList,sum));
			}
		}
		private void CheckLeft(){
			if(x>0){
			int cx = x-1;
			int cy = y;
				updateList.add(new node(cx,cy,grid,move,updateList,sum));
			
			}
		}
		
		
	}
	
	@Override
	public String solve() {
		int dim = 80;
		int [][] grid = new int[dim][dim];
		int [][] move= new int[dim][dim];
		
		File aFile = new File("src//EulerProblems//matrix.txt");
		try {
			Scanner inScanner = new Scanner(aFile);
			int i = 0;
			while (inScanner.hasNextLine()) {
				String b = inScanner.nextLine();
				Scanner scanner2 = new Scanner(b);
				scanner2.useDelimiter(",");
				int j =0;
				while(scanner2.hasNext()){
					grid[j][i] = Integer.parseInt(scanner2.next());
					j+=1;
				}
				i+=1;
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		
		ArrayList<node> newList = new ArrayList<node>();
		newList.add(new node(0,0,grid,move,newList,0));
		
		
		while(!newList.isEmpty()){
			ArrayList<node> runList = new ArrayList<node>();
			runList.addAll(newList);
			for(node a: runList){
				a.move();
			}
		}

		
		return String.valueOf(move[dim-1][dim-1]);
	}

}
