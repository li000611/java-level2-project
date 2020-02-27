package polymorphism;
//Compile time polymorphism is also known as static polymorphism.
//This type of polymorphism is achieved by function overloading or 
//operator overloading
//1.Example:By using different types of arguments

//Java program for Method overloading
public class MultiplyFun {
	
    //Method with 2 parameter
	static int Multiply(int a, int b) {
		return a*b;	
	}
	
	//Method with the same name but 2 double parameters
		static double Multiply(double a, double b) {
			return a*b;	
		}

	public static void main(String[] args) {
		System.out.println(MultiplyFun.Multiply(2,4));
		System.out.println(MultiplyFun.Multiply(5.5, 6.3));
		
	}

}
