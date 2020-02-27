package generics;


//A simple Java program to show multiple type parameters in Java Generics
//We use <>to specify Parameter type
//We can also pass multiple Type parameters in Generic classes.
public class Test2<T, U> {
         T obj1;  //An object of Type T
         U obj2;   //An object of Type U
         
         //constructor
         Test2(T obj1, U obj2){
        	 this.obj1 = obj1;
        	 this.obj2 = obj2;
         }
	
         //To print objects of T and U
         public void print() {
        	 System.out.println(obj1);
        	 System.out.println(obj2);
         }
	
	public static void main(String[] args) {
		Test2 <String, Integer> obj = new Test2<String, Integer>("GfG", 15);
		obj.print();
	}
}
