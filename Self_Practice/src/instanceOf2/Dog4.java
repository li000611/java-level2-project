package instanceOf2;

//Downcasting without the use of java instanceof
public class Dog4 extends Animal {
	
	static void method(Animal a) {
		Dog4 d =(Dog4)a; //downcasting
		System.out.println("ok downcasting performed");
	}
	
	public static void main(String []args) {
		Animal a = new Dog4();
		Dog4.method(a);
	}
	

}
