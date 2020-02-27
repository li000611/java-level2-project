package polymorphism;
//Compile time Polymorphism
//Java program for operator overloading
public class OperatorOVERDDN {
	
	void operator(String str1, String str2) {
		String s = str1 + str2;
		System.out.println("Concatinated String - " + s);
	}
	
	void operator(int a , int b) {
		int c = a+b;
		System.out.println("Sum = " + c);
	}

	public static void main(String[] args) {
		OperatorOVERDDN obj = new OperatorOVERDDN();
		obj.operator(2, 3);
		obj.operator("joe", "now");	

	}

}
