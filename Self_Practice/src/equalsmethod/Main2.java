package equalsmethod;

public class Main2 {
	//Driver class to test the Complex class
	public static void main(String[] args) {
		Complex2 c1 = new Complex2(10, 15);
		Complex2 c2 = new Complex2(10, 15);
	
	if(c1.equals(c2)) {
		System.out.println("Equal ");
	}else {
		System.out.println("Not Equal");
	}

   }
}
