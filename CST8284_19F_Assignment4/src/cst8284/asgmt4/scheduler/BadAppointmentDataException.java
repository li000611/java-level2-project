/* 
 * File name: BadAppointmentDataException.java
 * Author:Min Li 
 * Course: CST8284_302_OOP
 * Assignment:4
 * Date: 2019-12-04
 * Professor: Dave Houtman
 * Purpose: This is a customized exception class derived from RuntimeExecetion.
 */

package cst8284.asgmt4.scheduler;

import javax.swing.JOptionPane;

public class BadAppointmentDataException extends RuntimeException {
	private String description;
	public BadAppointmentDataException(String message, String description) {
		super(message);
		setDescription(description);
	}
	
	public BadAppointmentDataException() {
		this("Please try again", "Bad data entered");
	}
	
	public String getDescription() { return description; }
	public void setDescription(String description) {this.description = description;}
	
	
}