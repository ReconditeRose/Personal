package EulerProblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class triangles implements Problem {
static final double epsilon = 0.000001;
	private class Vector{
		double x;
		double y;
		Vector(int xNew, int yNew){
			x = (float) xNew;
			y = (float) yNew;
		}
		private double dotProduct(Vector a){
			return x*a.getX()+y*a.getY();
		}
		double getX(){
			return this.x;
		}
		double getY(){
			return this.y;
		}
		double size(){
			return Math.sqrt(x*x+y*y);
		}
		public double angleBetween(Vector a){
			return Math.acos(dotProduct(a)/(size()*a.size()));
		}
	}


	private boolean contains(Vector a, Vector b, Vector c){
		double sum = 0;
		sum+=a.angleBetween(b);
		sum+=b.angleBetween(c);
		sum+=a.angleBetween(c);
		System.out.println(sum);
		
		
		if(sum<2*Math.PI+epsilon && sum>2*Math.PI-epsilon){
			System.out.println("true");
		return true;
		}else{

			return false;
		}
	}
	
	@Override
	public String solve() {
		File aFile = new File("src//EulerProblems//triangles.txt");
		Vector a,b,c;
		int sum = 0;
		try {
			Scanner inScanner = new Scanner(aFile);
			while (inScanner.hasNextBigInteger()) {
				a = new Vector(inScanner.nextInt(),inScanner.nextInt());
				b = new Vector(inScanner.nextInt(),inScanner.nextInt());
				c = new Vector(inScanner.nextInt(),inScanner.nextInt());
				if(contains(a,b,c)){
					sum++;
				}
				
				inScanner.nextLine();
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		
		return (""+sum);
	}

}
