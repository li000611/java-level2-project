package cst8284.genericTable;
public class Triangle extends BasicShape{
	
	public Triangle() {
		this(1.0);
	}
	public Triangle(double width) {
		super(width);
		//this.width=width;
	}
	public Triangle(Triangle t) {
		this(t.getWidth());
	}


	@Override
	public double getArea() {
		return (Math.sqrt(3) / 4) * (getWidth() * getWidth());
	}

	@Override
	public double getPerimeter() {
		return 3*getWidth();
	}
	@Override
	public boolean equals(Object obj) {
		return ((obj) instanceof Triangle && this.getWidth() == ((Triangle) obj).getWidth());
	}			

	@Override
	public String toString() {
		return "Triangle";
	}


}
