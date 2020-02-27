package cst8284.asgmt2.employee;
/*Course Name: CST8284_302
 * Student Name: Min Li
 * Class Name:  Dentist
 * Date:  2019-10-26
 */

import java.util.Scanner;

public class Dentist extends Employee{
	
	public Dentist(String fullName) {
		this.setName(fullName);
	}
	
	@Override
	public String getActivityType() {
		System.out.println("Enter a category from the following menu:"+ 
				"\n 1. Assessment" + 
				"\n 2. Filling" + 
				"\n 3. Crown" + 
				"\n 4. Cosmetic Repair");
		 
	    Scanner input = new Scanner(System.in);
	    switch(input.nextInt()) {
	       case 1:
	       return "Assessment";
	       
	       case 2:
	       return "Filling";
	       
	       case 3:
	       return "Crown";
	       
	       case 4:
	       return "Cosmetic Repair";    
	       
	    }
	   
		return null;
	    
		}

}