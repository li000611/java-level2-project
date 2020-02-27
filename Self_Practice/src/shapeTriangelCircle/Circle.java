package shapeTriangelCircle;

public class Circle extends Shape {
	
	private double radius;
	
	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}
	 
     public void setRadius(double radius) {
		this.radius = radius;
	}

   //override abstract method from Shape class to calculate perimeter
	@Override
	public double calPerimeter() {
		return 2 * Math.PI * radius;
	}

	//override abstract method from Shape class to return "shape"
	@Override
	public String getType() {
		return getColor()+" Circle";
    }
	
	public static void main(String[] args) {
		Shape s1 = new Triangle("black", 3, 4, 5);
		Shape s2 = new Circle("yellow",3);
		System.out.println(s1.getType());
		System.out.println(s1.calPerimeter());
		System.out.println(s2.getType());
		System.out.println(s2.calPerimeter());
	}
}
