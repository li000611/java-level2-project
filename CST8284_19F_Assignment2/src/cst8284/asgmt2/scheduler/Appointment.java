package cst8284.asgmt2.scheduler;
/*Course Name: CST8284_302
 * Student Name: Min Li
 * Class Name:  Appointment
 * Date:  2019-10-26
 */

import java.io.Serializable;
import java.util.Calendar;

public class Appointment implements Serializable{
	private Calendar aptDate;
	private String firstName, lastName;
	private TelephoneNumber phone;
	private Activity activity;
	public static final long serialVersionUID = 1L;
	
	

	public Appointment(Calendar cal, String fullName, TelephoneNumber phone, Activity act) {
		this(cal, fullName.trim().split(" ")[0], fullName.trim().split(" ")[1], phone, act);
	}
	
	public Appointment(Calendar cal, String firstName, String lastName, TelephoneNumber phone, Activity act) {
		setFirstName(firstName.trim()); 
		setLastName(lastName.trim());
		setCalendar(cal); 
		setPhone(phone);
		setActivity(act);
	}
	
	public Calendar getAptDate() {return aptDate;}

	public void setAptDate(Calendar aptDate) {this.aptDate = aptDate;}
	
	public Calendar getCalendar() {return aptDate;}
	public void setCalendar(Calendar aptDate) {this.aptDate = aptDate;}
	
	public String getFirstName() {return firstName; }
	public void setFirstName(String firstName) {this.firstName = firstName;}
	
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	
	public TelephoneNumber getPhone() {return phone;}
	public void setPhone(TelephoneNumber phone) {this.phone = phone;}
	
	public Activity getActivity() {return activity;}
	public void setActivity(Activity activity) {this.activity = activity;}
	
	public String toString() {
		return getCalendar().getTime() + "\n" +
			   getFirstName() + " " + getLastName() + "\n" + 
			   getPhone() + "\n" +
			   getActivity();
	}



}
