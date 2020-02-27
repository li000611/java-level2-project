package generics;

//A simple Java program to show working of user defined Generic functions

public class Test3 {

	 //A generic method example
	static <T> void genericDisplay(T element) {
		System.out.println(element.getClass().getName() + " = " + element);
	}
	
	public static void main(String[] args) {
		//calling generic method with Integer argument
		genericDisplay(11);
		
		//calling generic method with String argument
		genericDisplay("GeeksForGeeks");
		
		//calling generic method with double argument
				genericDisplay(1.0);		
	}
}
