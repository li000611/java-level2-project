package generics;

//A simple Java program to show working of user defined Generic classes.
//We use <>to specify Parameter type
//To create an instance of generic class
//BaseType <Type> obj = new BaseType <Type>()
//Note: In Parameter type we can not use primitives like 'int', 'char' or'double'
public class Test<T> {
        //An object of type T is declared
        T obj;
        Test(T obj){this.obj = obj;}//constructor
        public T getObject() {return this.obj;}


        public static void main(String[] args) {
        	
        	//instance of Ieteger type
        	Test<Integer>iObj = new Test<Integer>(15);
        	System.out.println(iObj.getObject());
        	
        	//instance of String type
        	Test<String> sObj = new Test<String>("GeeksForGeeks");
        	System.out.println(sObj.getObject());		

	}

}
