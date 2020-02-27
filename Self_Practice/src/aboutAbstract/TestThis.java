package aboutAbstract;

public class TestThis {
	
	String name;
	int age;
	 
      TestThis(){
    	  System.out.println(this);	 
      }
      
      TestThis(String name, int age){
    	  this.name = name;
    	  this.age = age;
      }
      
      void show() {
    	  System.out.println(this);
      }
      void show2() {
    	  System.out.println(name+" "+age);
      }
      
	public static void main(String[] args) {
	    TestThis tt = new TestThis();
	    tt.show();
	    System.out.println(tt);
	    
	    System.out.println("-----------");
	    TestThis tt2 = new TestThis("Wangjianlin", 18);  
	    tt2.show2();
	}

}
 