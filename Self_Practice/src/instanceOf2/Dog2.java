package instanceOf2;

//instanceof in java with a variable that have null value
//If we apply instanceof operator with a variable that 
//have null value, it returns false.
public class Dog2 {
         
	public static void main(String args[]) {
		Dog2 d = null;
		System.out.println(d instanceof Dog2); //false
	}
}
