/* 
 * File name: SchedulerLauncher.java
 * Author:Min Li 
 * Course: CST8284_302_OOP
 * Assignment:4
 * Date: 2019-12-04
 * Professor: Dave Houtman
 * Purpose: This is main class, provides entry of this project.
 */

package cst8284.asgmt4.scheduler;

import cst8284.asgmt4.employee.Dentist;

public class SchedulerLauncher {

	public static void main(String[] args) {
		
       javax.swing.SwingUtilities.invokeLater(new Runnable() {
    	   public void run() {
    		   new Scheduler(new Dentist("Dr. Andrews")).launch(); 
    		 
    	   }
        });
	}
}