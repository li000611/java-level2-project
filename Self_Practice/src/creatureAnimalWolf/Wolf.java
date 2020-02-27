package creatureAnimalWolf;

public class Wolf extends Animal{
	
	public Wolf() {
		super("The wolf", 3);
		System.out.println("Wolf no parameter constructor");
	}
	
	public static void main(String[] args) {

         new Wolf();
	}

}
