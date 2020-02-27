package shapeTriangelCircle;

public abstract class Shape {
	{
		System.out.println("Run Shape...");
	}
	
	private String color;
	
	//define an abstract method to calculate perimeter
	public abstract double calPerimeter();
	
	//define an abstract method to return shape
	public abstract String getType();
	
	//a constructor of class Shape, it's not used to instantiate Shape object
	//but it is used by subclass
	public Shape() {}
	
	public Shape(String color)
	{
		System.out.println("Run Shape's constructor...");
		this.color = color;
	}
		
	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
}
