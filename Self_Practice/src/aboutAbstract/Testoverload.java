package aboutAbstract;

public class Testoverload {
	void show() {
		System.out.println("show()");
	}
	
    void show(int i) {
    	System.out.println("show(int)");
   
    show(double d) {
    	System.out.println("show (double)");
    }
    
    show(int o, double p) {
    	System.out.println("show(int, double)");
    }
    
    show(double r, int s) {
    	System.out.println("show(double, int)");
    }
    
    }
	public static void mian(String[]args) {
		Testoverload to = new Testoverload();
		to.show();
		to.show(0.0);
		to.show(10);
		to.show(1, 0.0);
		to.show(0.5, 2);	
	}
}
