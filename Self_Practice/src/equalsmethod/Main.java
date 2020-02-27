package equalsmethod;

//Driver class to test the Complex class
public class Main {

	public static void main(String[] args) {
		Complex c1 = new Complex(10, 15);
		Complex c2 = new Complex(10, 15);
	
	if(c1 == c2) {
		System.out.println("Equal ");
	}else {
		System.out.println("Not Equal");
	}

   }
}

/*
 * The reason for printing"Not Equal"is simple: when we compare c1 and c2, it is checked 
 * whether both c1 and c2 refer to same object or not(object variables are always references in Java).
 * c1 and c2 refer to two different objects, hence the value(c1 == c2) is false.
 * If we create another reference say c3 like following, then(c1 == c3) will give true.
 */