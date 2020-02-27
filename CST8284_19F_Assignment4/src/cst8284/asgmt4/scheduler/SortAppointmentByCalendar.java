/* 
 * File name: SortAppointmentByCalendar.java
 * Author:Min Li 
 * Course: CST8284_302_OOP
 * Assignment:3
 * Date: 2019-11-24
 * Professor: Dave Houtman
 * Purpose: This class compares two appointments according their time, implements Comparator<Appointment>
 * */
package cst8284.asgmt4.scheduler;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class compares two appointments according their time, implements Comparator
 * @author Min Li
 * @version 2.0
 */
public class SortAppointmentByCalendar implements Comparator<Appointment>{

    /**
     * Override method compare two appointment according to calendar
     * @param  a1 is  an Appointment type, refers to the first appointment
     * @param  a2 is  an Appointment type, refers to the second appointment
     * @return an int 0 if these two appointments' time is the same, return an int positive number if a1's time is greater than a2's,
     *         return an int negative number if a1's time is less than a2's      
     */
	//Reference: https://howtodoinjava.com/sort/sort-arraylist-objects-comparable-comparator/
    @Override
	public int compare(Appointment a1,  Appointment a2) {
		return a1.getCalendar().compareTo(a2.getCalendar());
	}	
}
