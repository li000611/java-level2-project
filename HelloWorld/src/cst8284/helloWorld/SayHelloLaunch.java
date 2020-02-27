package cst8284.helloWorld;

public class SayHelloLaunch {

	public static void main(String[] args) {
		new SayHello("Bob");    //1-arg constructor
		new SayHello("Mary");   //1-arg constructor
		new SayHello();         //no-arg constructor
		new SayHello(args);      //use command line as string array		

	}

}
