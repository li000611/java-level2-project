/* 
 * File name: Dentist.java
 * Author:Min Li 
 * Course: CST8284_302_OOP
 * Assignment:4
 * Date: 2019-12-04
 * Professor: Dave Houtman
 * Purpose: A subclass of Employee which contains fields, constructor and a method.
 */
package cst8284.asgmt4.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dentist extends Employee {
	
	private static String[] workDescription = {"Assessment", "Filling", "Crown", "Cosmetic Repair"};

	public Dentist(String fullName) {
		super (fullName);
	}

	public ArrayList<String> getActivityType() {
		ArrayList<String> res = new ArrayList<>();
		for(String str : workDescription) {
			res.add(str);
		}
		return res;
	}
	
	}
//		System.out.println("Enter a selection from the following menu:");
//		int i = 1;
//		for (String description: workDescription)
//			System.out.println(i++ + "." + description);
//		int ch = scan.nextInt();
//		scan.nextLine(); // 'eat' the next line in the buffer
//		System.out.println();  // add a space
//		return workDescription[ch-1];
//		return Arrays.asList(this.workDescription);
		
	


