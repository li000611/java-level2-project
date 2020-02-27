package arraylist;
//Java program to convert a ArrayList to an array using add() in a loop.
import java.util.*;
public class GFG {

	public static void main(String[] args) {
		String[] geeks = {"Dana", "Peter", "Matilda", "Amy"};
		List<String>al = new ArrayList<String>();
		
		//Array to ArrayList Conversion
		for(String geek: geeks)
			al.add(geek);
		System.out.println(al);
	}
}
