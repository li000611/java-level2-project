package instanceof3;

class Call {
	
	void invoke(Printable p) {//upcasting
		
     if(p instanceof A) {
    	 A a = (A)p; //downcasting
    	 a.a();
     }
     
     if(p instanceof B) {
    	 B b = (B)p; //downcasting
    	 b.b();
     }    
  }
}  //end of Call class