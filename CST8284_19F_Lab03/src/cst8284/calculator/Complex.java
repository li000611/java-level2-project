package cst8284.calculator;

public class Complex {
	private double real = 0;
	private double imag = 0;
	
	public Complex(String cStr){
		this(cStr.split("(?=\\+)|(?=\\-)"));  
	}
	
	public Complex(String[] cStr){
		this(cStr[0], cStr[1]);
	}

	public Complex(String r, String i){
		this(Integer.parseInt(r), Integer.parseInt(i.split("i")[0]));
	}
	
	public Complex(int r, int i){
		this((double) r, (double) i);
	}
	
	public Complex(double r, double i){
		setReal(r);
		setImag(i);
	}
	
	public Complex(){
		this(0,0);	
	}
		
	public double getReal() {
		return real;
	}
	
	public double getImag() {
		return imag;
	}
	
	public void setReal(double real) {
		this.real = real;
	}
	
	public void setImag(double imag) {
		this.imag = imag;
	}
	
	public Complex getComplex() {
		return this;
	}
	
	public String toString() {
		String sign = "+";
		if (imag < 0) {
			sign = "-";
		}	
		return String.format("%.1f %s %.1fi", real, sign, Math.abs(imag));
	}
	//Bonus A
	
	public boolean isZero() {
		return(this.getReal()==0 && this.getImag()==0);
	}
 
	}

