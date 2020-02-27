package cst8284.asgmt2.scheduler;
/*Course Name: CST8284_302
 * Student Name: Min Li
 * Class Name:  Activity
 * Date:  2019-10-26
 */

import java.io.Serializable;

public class Activity implements Serializable{

	private static final long serialVersionUID = 1L;
	private String descriptionOfWork;
	private String category;

	public String getDescription() {
		return descriptionOfWork;
		}
	
	public void setDescription(String description) {
		this.descriptionOfWork = description;
		}
	
	public String getCategory() {
		return category;
		}
	public void setCategory(String category) {
		this.category = category;
		}
	
	public String toString() {
		return getCategory()+"\n"+getDescription();
		}
	
	
	
}
