 package aboutAbstract;

public class TestSubAbstract extends TestAbstract {
        public static void main(String[] args) {
        	
        	 TestSubAbstract ts = new TestSubAbstract();
        	 ts.show();

		 System.out.println("----------------");
		 TestAbstract ta = new TestSubAbstract();
		 ta.show();
	}
	
        public void show() {
        	System.out.println("Chouxiangleizhenlihai.");
        }
}
