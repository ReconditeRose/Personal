package EulerProblems;
import eulerFunctions.Prime;
public class rational{
	private int num,den;
	public rational(int num, int den){
		this.num = num;
		this.den = den;
		this.simplify();
	}
	public int numbersBetween(rational first, rational second){
		int tempDen = den;
		int tempNum = num;
		int sum =0;
		this.num = (first.getNum()*this.den-this.num*first.getDen())/first.getDen()+2;
		while(this.compare(second)<0){
			if(!couldSimplify()){
			sum++;
			System.out.println(num+"/"+den);
			}
			this.num++;
		}
		this.num = tempNum;
		this.den = tempDen;
		return sum;
	}
	public int compare(rational a){
		return (this.num*a.getDen()-a.getNum()*this.den);
	}
	public void add(rational appen){
		this.num = appen.getNum()*this.getDen() + this.num*appen.getDen();
		this.den = this.den*appen.getDen();
		this.simplify();
		
	}
	public void subtract(rational appen){
		rational temp  = new rational(-appen.getNum(),appen.getDen());
		add(temp);
	}
	public void neg(){
		this.num*= -1;
	}
	public void invert(){
		int temp = num;
		this.num = den;
		this.den = temp;
	}
	public void product(rational appen){
		this.num *= appen.getNum();
		this.den *= appen.getDen();
		this.simplify();
		
	}
	public void quotient(rational appen){
		rational temp  = new rational(appen.getNum(),appen.getDen());
		temp.invert();
		product(temp);
	}
	public int getNum(){
		return this.num;
	}
	public int getDen(){
		return this.den;
	}
	private void simplify(){
		if(den<0){
			den*= -1;
			num*= -1;
		}
		if(num>0){
		int d = Prime.GCD(this.num, this.den);
		this.num/= d;
		this.den/= d;
		}else if(num<0){
			this.neg();
			this.simplify();
			this.neg();
		}else{
			this.den = 1;
		}
	}
	
	private boolean couldSimplify(){
		int tempDen = den;
		int tempNum = num;
		if(den<0){
			den*= -1;
			num*= -1;
		}
		if(num>0){
		int d = Prime.GCD(this.num, this.den);
		this.num/= d;
		this.den/= d;
		}else if(num<0){
			this.neg();
			this.simplify();
			this.neg();
		}else{
			this.den = 1;
		}
		boolean action = !(tempDen==den && tempNum == num);
		this.num = tempNum;
		this.den = tempDen;
		return action;
	}
	public String toString(){
		return (this.num+"/"+this.den+" ");
	}
}
