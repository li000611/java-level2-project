package cst8284.asgmt2.scheduler;
/*Course Name: CST8284_302
 * Student Name: Min Li
 * Class Name:  SchedulerLauncher
 * Date:  2019-10-26
 */

import cst8284.asgmt2.employee.Dentist;
import cst8284.asgmt2.employee.Employee;

public class SchedulerLauncher {

	public static void main(String[] args) {
		
		Employee emp = new Dentist("Dr.Andrews");
		Scheduler scheduler = new Scheduler(emp);
		scheduler.launch();
				
			}
	

}
