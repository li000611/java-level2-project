package instanceOf;

public class ProperUseOfInstanceOf {

	public static void main(String[] args) {
		makeItMove(new Fish());
		makeItMove(new Bird());
		makeItMove(new Kangroo());
	}

	private static void makeItMove(Kangroo kangroo) {		
	}

	private static void makeItMove(Bird bird) {
	}

	private static void makeItMove(Fish fish) {
	}
  /**
   * This method implementation doesn't care at all 
   * about Fish/Bird/Kangroo. It just knows that it has
   * been passed an Animal. Different versions fo 'move'
   * are called, sepcific to each Animal.
   * @param animal
   */
	
	
    public static void makeItMove(Animal animal) {
    	animal.move();
    }
}
