/* 
 * File name: Activity.java
 * Author:Min Li 
 * Course: CST8284_302_OOP
 * Assignment:4
 * Date: 2019-12-04
 * Professor: Dave Houtman
 * Purpose: This class declares an entity of Activity which shows category an description, and implements Serializable.
 */

package cst8284.asgmt4.scheduler;

import java.io.Serializable;

public class Activity implements Serializable {
	private String descriptionOfWork;
	private String category;
	
	public Activity(String description, String category) {
		setDescription(description);
		setCategory(category);
	}
	
	public Activity() {
	}

	public String getDescription() {return descriptionOfWork;}
	public void setDescription(String description) {this.descriptionOfWork = description;}
	
	public String getCategory() {return category;}
	public void setCategory(String category) {this.category = category;}
	
	public String toString() {return getCategory() + "\n" + getDescription();}
}
