package cst8284.asgmt2.scheduler;
/*Course Name: CST8284_302
 * Student Name: Min Li
 * Class Name:  TelephoneNumber
 * Date:  2019-10-26
 */

import java.io.Serializable;

public class TelephoneNumber implements Serializable {

	private static final long serialVersionUID = 1L;
	private int areaCode, lineNumber, prefix;
	
	public TelephoneNumber(String phoneNumber) {
		int areaCode = Integer.parseInt(phoneNumber.split("-")[0].trim());
		int prefix = Integer.parseInt(phoneNumber.split("-")[1].trim());
		int lineNumber = Integer.parseInt(phoneNumber.split("-")[2].trim());
		setAreaCode(areaCode); setPrefix(prefix); setLineNumber(lineNumber);
	}	
	
	public int getAreaCode() {return areaCode;}
	public void setAreaCode(int areaCode) {this.areaCode = areaCode;}
	public int getPrefix() { return prefix;}
	public void setPrefix(int prefix) {this.prefix = prefix;}
	public int getLineNumber() {return lineNumber;}
	public void setLineNumber(int lineNumber) {this.lineNumber = lineNumber;}
	
	public String toString() {return "(" + getAreaCode() +") "+ getPrefix() + "-" + getLineNumber();}

}
