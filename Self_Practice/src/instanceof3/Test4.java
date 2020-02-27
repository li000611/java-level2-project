package instanceof3;

class Test4 {
	public static void main (String args[]) {
		Printable p = new B();
		Call c = new Call();		
		c.invoke(p);
	}

}
