package animalBirdWolfCompositeTest;

public class Bird {
         private Animal a;
         
         public Bird(Animal a) {
        	 this.a = a;
         }
	 
      
         public void breath() {
        	 a.breath();
         }
         
         public void fly() {
        	 System.out.println("I fly in the sky...");
     	}
         
	
}
