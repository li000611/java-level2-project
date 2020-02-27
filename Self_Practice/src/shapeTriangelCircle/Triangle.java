package shapeTriangelCircle;

public class Triangle extends Shape{
	
	//define three sides of Triangle
	private double a;
	private double b;
	private double c;
	
	public Triangle(String color, double a, double b, double c) {
		super(color);
		this.setSides(a,b,c);
	}
	
	public void setSides(double a, double b, double c) {
		if (a>=b+c || b>=a+c || c>=a+b) {
			System.out.println("The sum of two sides of triangle is bigger than the the third side.");
			return;
		}
		this.a = a;
		this.b = b;
		this.c = c;
	}

	//override abstract method from Shape class to calculate perimeter
	@Override
	public double calPerimeter() {
		return a+b+c;
	}

	//override abstract method from Shape class to return "shape"
	@Override
	public String getType() {
		return "triangle";
	}
	
	
	
      

}
