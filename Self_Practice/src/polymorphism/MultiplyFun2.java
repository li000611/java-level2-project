package polymorphism;
//Compile time Polymorphism

//By using different numbers of arguments

//Java program for Method overloading
public class MultiplyFun2 {

	//Method with 2 parameters
	static int Multiply(int a, int b) {
		return a * b;
	}
	
	//Method with the same name but 3 parameters
	static int Multiply(int a , int b, int c) {
		return a*b*c;
	}
		

	public static void main(String[] args) {
		System.out.println(MultiplyFun2.Multiply(2, 4));
		System.out.println(MultiplyFun2.Multiply(2, 7, 3));

	}

}
