package arraylist;
//Java code to illustrate the difference between 
//length in java Array and size in ArrayList
import java.util.ArrayList;
public class ArrayLengthAndArrayListSize {
   
	public static void main(String[] args) {
		//creating an array A[] for 10 elements
		String A[]= new String[10];
		
		//store e elements
		A[0] = "Hello";
		A[1] = "Geeks!";
		
		//print length of array A[]
		System.out.println(A.length);
		
		//creating an ArrayList
		ArrayList<String>al = new ArrayList<String>();
		
		//add 3 elements
		al.add("G");
		al.add("F");
		al.add("G");
		
		//print size of ArrayList
		System.out.println(al.size());		
		}
}
