package cst8284.asgt1.scheduler;

/*Course Name: CST8284_300
 * Student Name: Min Li
 * Class Name:  TelephoneNumber
 * Date:  2019-9-25
 */

public class TelephoneNumber {
	private int areaCode;
	private int prefix;
	private int lineNumber;
	
	public TelephoneNumber(String phoneNumber) {
		String[] string=phoneNumber.split("-"); 
		areaCode = Integer.parseInt(string[0]);
		prefix = Integer.parseInt(string[1]);
		lineNumber= Integer.parseInt(string[2]);
	}
	
	public int getAreaCode() {
		return areaCode;
	}
	
	public void setareaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	
	 public int getPrefix() {
		return prefix;
	}

	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public String toString() {
		return "("+areaCode +") "+ prefix +"-"+ lineNumber;
	}
	
	
}
	

