package cst8284.genericTable;

public abstract class BasicShape implements Comparable<BasicShape>{
	
	private double width;
	protected BasicShape(double width) {setWidth(width);}
	
	public double getWidth(){return width;}
	public void setWidth(double width){this.width = width;}
	
	
	@Override
	public int compareTo(BasicShape obj){
	return (Math.abs(this.getArea()-obj.getArea())<1e-8)?0:(this.getArea()-obj.getArea()<0)?-1:1;
	}

	/*
	 * @Override public int compareTo(BasicShape obj){
	 * if(Math.abs(this.getArea()-obj.getArea()) <= 1e-8) { return 0; }else if
	 * (this.getArea()-obj.getArea() < 0 ) { return -1; } else return 1; }
	 */
	
		
	@Override
	public String toString(){
		return ("BasicShape" + super.toString());
	}
	
	public abstract double getArea();
	public abstract double getPerimeter();
	
	
	
}