package toString;

//Java program to illustrate working of toString()method
public class BestFriend2 {
	 String name;
	 int age;
	 String college;
	 String course;
	 String address;
	 
	 public BestFriend2(String name, int age, String college, String address){
		 this.name = name;
		 this.age = age;
		 this.college = college;
		 this.address = address;
	 }
	
	 @Override
	 public String toString() {
		 return name + " " + age + " " + college + " " + address;
	 }
	 
	  public static void main(String[]args) {
		  BestFriend2 b = new BestFriend2("Gulpreet Kaur",21, "M.TECH","Kiriburu");
		  System.out.println(b);
		  System.out.println(b.toString());
	  }
}
	
// Note:In all wrapper classes, all collection classes, String class, StringBuffer, StringBuilder classes
//toString() method is overriden for meaningful String representation. Hence, it is highly recommended to 
//override toString() method in our class also.
	


