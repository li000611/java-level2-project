package aboutAbstract;

public class MethodSignature {
	public int add( int a, int b) {
		int c = a+b;
		return c;
	}

	public static void main(String[] args) {
	       MethodSignature obj = new MethodSignature();
	       int  result = obj.add(56, 34);
	       System.out.println(result);
	}

}
