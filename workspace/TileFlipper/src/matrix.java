import java.util.ArrayList;

public class matrix {
	ArrayList<ArrayList<rational>> contents = new ArrayList<ArrayList<rational>>();
	private int[][] CompareTo;

	private class rational {
		private int num, den;

		public rational(int num, int den) {
			this.num = num;
			this.den = den;
			this.simplify();
		}

		public void add(rational appen) {
			this.num = appen.getNum() * this.getDen() + this.num
					* appen.getDen();
			this.den = this.den * appen.getDen();
			this.simplify();

		}

		public void subtract(rational appen) {
			rational temp = new rational(-appen.getNum(), appen.getDen());
			add(temp);
		}

		public void mod(int i) {
			this.num = this.num % i;
		}

		public void neg() {
			this.num *= -1;
		}

		public void invert() {
			int temp = num;
			this.num = den;
			this.den = temp;
		}

		public void product(rational appen) {
			this.num *= appen.getNum();
			this.den *= appen.getDen();
			this.simplify();

		}

		public void quotient(rational appen) {
			rational temp = new rational(appen.getNum(), appen.getDen());
			temp.invert();
			product(temp);
		}

		public int getNum() {
			return this.num;
		}

		public int getDen() {
			return this.den;
		}

		private void simplify() {
			if (den < 0) {
				den *= -1;
				num *= -1;
			}
			if (num > 0) {
				int d = Prime.GCD(this.num, this.den);
				this.num /= d;
				this.den /= d;
			} else if (num < 0) {
				this.neg();
				this.simplify();
				this.neg();
			} else {
				this.den = 1;
			}
		}

		public String toString() {
			return (this.num + "/" + this.den + " ");
		}

	}

	public matrix(int[][] a) {
		CompareTo = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			ArrayList<rational> temp = new ArrayList<rational>();
			for (int j = 0; j < a[0].length; j++) {
				temp.add(new rational(a[i][j], 1));
				
			}
			contents.add(temp);
		}
	}

	public void printAll() {
		for (int i = 0; i < contents.size(); i++) {
			for (int j = 0; j < contents.get(0).size(); j++) {
				System.out.print(contents.get(i).get(j));
			}
			System.out.println();
		}
	}

	public void toRREF() {
		// check if rows are 0, if so we're done
		int rowCount = contents.size();
		if (rowCount == 0)
			return;
		//
		int columnCount = contents.get(0).size();

		int lead = 0;
		for (int r = 0; r < rowCount; r++) {
			if (lead >= columnCount) {
				break;
			}

			int i = r;
			while (contents.get(i).get(lead).getNum() == 0) {
				i++;
				if (i == rowCount) {
					i = r;
					lead++;
					if (lead == columnCount) {
						return;
					}

				}
			}
			ArrayList<rational> temp = contents.get(r);
			contents.set(r, contents.get(i));
			contents.set(i, temp);

			rational lv1 = new rational(contents.get(r).get(lead).getNum(),
					contents.get(r).get(lead).getDen());
			for (int j = 0; j < columnCount; j++) {
				contents.get(r).get(j).quotient(lv1);
			}

			for (int k = 0; k < rowCount; k++) {
				if (k != r) {
					rational lv = new rational(contents.get(k).get(lead)
							.getNum(), contents.get(k).get(lead).getDen());
					for (int j = 0; j < columnCount; j++) {
						rational appen = new rational(lv.num
								* contents.get(r).get(j).num, lv.den
								* contents.get(r).get(j).den);
						contents.get(k).get(j).subtract(appen);
					}
				}
			}
			lead++;
		}

	}
	public boolean checkSolution(int[] a){
		for(int i=0;i<CompareTo.length;i++){
			for(int j=0;)
		}
		return false;
	}
	private void flipCell(int x, int y, boolean domain){
		try{
			CompareTo[x][y]= (CompareTo[x][y]+1)%2;
			if(domain){
				flipCell(x+1,y,false);
				flipCell(x-1,y,false);
				flipCell(x,y+1,false);
				flipCell(x,y-1,false);
			}
			
		}catch(Exception e){
			
		}
	}
	
	public int[] returnSolutionRow() {
		int[] solutions = new int[this.contents.size()
				* this.contents.get(0).size()];
		for (int i = 0; i < this.contents.size(); i++) {
			System.out.println();
			for (int j = 0; j < this.contents.get(0).size(); j++) {
				if (this.contents.get(i).get(j).getNum() < 0) {
					this.contents.get(i).get(j).neg();
				}
				this.contents.get(i).get(j).mod(2);
				System.out.print(this.contents.get(i).get(j));
			}
		}

		int getRow = this.contents.get(0).size() - 2;
		while (this.contents.get(getRow).get(getRow).getNum() != 1) {
			System.out.println("RAWR");
			getRow--;
		}
		getRow++;
		// boolean contin= true;
		// while(contin){
		// for(int i =0;i<this.contents.size()-1;i++){
		// if(this.contents.get(i).get(getRow).getNum()==1){
		// contin = false;
		// break;
		// }
		// }
		// getRow--;
		// }
		// while (this.contents.get(getRow).get(getRow).getNum() == 1) {
		// getRow++;
		// if (getRow == this.contents.get(0).size()-2) {
		// getRow = this.contents.get(0).size()-1;
		// break;
		// }
		// }
		for (int i = 0; i < this.contents.size(); i++) {
			solutions[i] = this.contents.get(i).get(getRow).getNum();
		}
		return solutions;
	}
}
