package toString;

import java.util.ArrayList;

//Java program to illustrate working of toString()method

public class BestFriend3 {
	String name;
	 int age;
	 String college;
	 String course;
	 String address;
	 
	 public BestFriend3(String name, int age, String college, String address){
		 this.name = name;
		 this.age = age;
		 this.college = college;
		 this.address = address;
	 }
	

	  public static void main(String[]args) {
		  BestFriend3 b = new BestFriend3("Gulpreet Kaur",21, "M.TECH","Kiriburu");
		  System.out.println(b);
		  String s = new String("Gulpreet Kaur");
		  System.out.println(s);
		  Integer i = new Integer(21);
		  System.out.println(i);
		  ArrayList<String> l = new ArrayList<String>();
		  l.add("BIT");
		  l.add("M.TECH");
		  System.out.println(l);
	  }

	
	
}
