package equalsmethod;

//We can override the equals method in our class to check whether two objects have same data or not.
public class Complex2 {
	
	private static final Complex2 o = null;
	private double re;
	private double im;
	
	public Complex2(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	//Overriding equals() to compare two Complex2 obects
	@Override
	public boolean equals(Object o) {
		
		//If the object is compared with itself then return true
		if(o == this) {
			return true;
		}
		
		//Check if o is an isntance of Complex2 or not
		//"null instanceof [type]" also returns
		if(!(o instanceof Complex2)) {
			return false;
	}
	
	//typecast o to Complex2 so that we can compare data members
	Complex2 c = (Complex2) o ;
	
	//Compare the data members and return accordingly
	return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;	
}
}