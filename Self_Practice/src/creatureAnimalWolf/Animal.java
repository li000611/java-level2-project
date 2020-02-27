package creatureAnimalWolf;

public class Animal extends Creature {
	
	public Animal(String name) {
		
		System.out.println("Animal one parameter constructor, " + "this animal's name is" + name);
	}
  
	
	public Animal(String name, int age) {
		
		this(name);	
		System.out.println("Animal two parameter constructor, " + "this animal's age is " + age);
	}
}
     