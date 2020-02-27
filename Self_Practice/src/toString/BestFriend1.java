package toString;

//Java program to illustrate working of toString()method
public class BestFriend1 {
 
	 String name;
	 int age;
	 String college;
	 String course;
	 String address;
	 
	 public BestFriend1(String name, int age, String college, String address){
		 this.name = name;
		 this.age = age;
		 this.college = college;
		 this.address = address;
	 }
	
	  public static void main(String[]args) {
		  BestFriend1 b = new BestFriend1("Gulpreet Kaur",21, "M.TECH","Kiriburu");
		  System.out.println(b);
		  System.out.println(b.toString());
	  }
}
//Explanation:In the above program, we create an Object of BestFriend1 class and provide all the infomation of a friend. 
//But when we try to print the Object, then we are getting some output which is in the form of 
//classname@HashCode_in_Hexadeciaml_-form.If we want the proper information about BestFriend1 object,
//then we have to override toString()method of Object class in our BestFriend1 class. 

//BestFriend2 will do this function.