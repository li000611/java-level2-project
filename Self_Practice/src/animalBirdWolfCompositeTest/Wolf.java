package animalBirdWolfCompositeTest;

public class Wolf {
	
	private Animal a;
    
    public Wolf(Animal a) {
   	 this.a = a;
    }

    public void breath() {
   	 a.breath();
    }
    

    public void run() {
    	System.out.println("I run very fast...");
	}
    
  }


