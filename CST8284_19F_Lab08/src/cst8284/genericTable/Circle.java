package cst8284.genericTable;
public class Circle extends BasicShape{
	
	public Circle() {
		this(1.0);
	}

	public Circle(double width) {
		super(width);
		
	}
	public Circle(Circle circle) {
		this(circle.getWidth());
	}


	@Override
	public double getArea() {
		return Math.PI* (getWidth()/2*getWidth()/2);
	}


	@Override
	public String toString() {
		return "Circle";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			if(((Circle) obj).getWidth()==getWidth()){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public double getPerimeter() {
		return Math.PI* getWidth();
	}

}