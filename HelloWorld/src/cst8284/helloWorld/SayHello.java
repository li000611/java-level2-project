package cst8284.helloWorld;

public class SayHello {
	
	public SayHello() {
	  this("World");
	}
	
	public SayHello(String s) {
		this(new String[] {s});
	}
	
	
	public SayHello(String[] strAr) {
		for (int i=0; i < strAr.length; i++)
		System.out.println("hello " + strAr[i]);
	}

	/*
	public static void main(String args[]) {
		int x = 4;
		int y = 10;
		int z;
		
		z = x++ + ++y;
		System.out.print(z);
	}
    */
}
