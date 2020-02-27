package instanceOf2;

//Another example of java instanceof operator
public class Dog1 extends Animal {//Dog inherits Animal

	public static void main(String[] args) {
		Dog1 d = new Dog1();
		System.out.println(d instanceof Animal);

	}

}
