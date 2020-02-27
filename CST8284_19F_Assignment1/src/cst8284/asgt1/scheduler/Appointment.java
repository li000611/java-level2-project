package cst8284.asgt1.scheduler;
/*Course Name: CST8284_300
 * Student Name: Min Li
 * Class Name:  Appointment
 * Date:  2019-9-25
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Appointment {
	private Calendar aptDate;
	private String firstName;
	private String lastName;
	private TelephoneNumber phone;
	private Activity activity;
	
	
	public Appointment(Calendar cal, String fullName, TelephoneNumber phone, Activity activity ) {
		aptDate = cal;
		String [] s= fullName.split(" ");
		firstName =s[0];
		lastName =s[1];
		this.phone =phone;
		this.activity= activity;	
	}
	
	public Appointment(Calendar cal, String firstName, String lastName, TelephoneNumber phone, Activity activity ) {
		aptDate = cal;
		this.firstName =firstName;
		this.lastName =lastName;
		this.phone =phone;
		this.activity= activity;
	}

public Calendar getAptDate() {
	return aptDate;
}

public void setAptDate(Calendar aptDate) {
	this.aptDate = aptDate;
}

public String getFirtName() {
	return firstName;
}

public void setFirtName(String firtName) {
	this.firstName = firtName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public TelephoneNumber getPhone() {
	return phone;
}

public void setPhone(TelephoneNumber phone) {
	this.phone = phone;
}

public Activity getActivity() {
	return activity;
}

public void setActivity(Activity activity) {
	this.activity = activity;
}

public String toString() {
	
	//reference:https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
	
    SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd yyyy HH:mm");
     return sdf.format(aptDate.getTime()) + "\n" + firstName + " " + lastName + "\n"
    		 + phone.toString() + "\n" + activity.toString();
}
}
