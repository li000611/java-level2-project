package cst8284.asgt1.scheduler;
/*Course Name: CST8284_300
 * Student Name: Min Li
 * Class Name:  Activity
 * Date:  2019-9-25
 */

public class Activity {
	private String descriptionOfWork;
	private String category;
	
	   public Activity(String description) {
	        this.descriptionOfWork = description;
	        this.category = "";
	    }
	public Activity(String description, String category) {
		this.descriptionOfWork = description;
		this.category = category;
	}

	public String getDescriptionOfWork() {
		return descriptionOfWork;
	}

	public void setDescriptionOfWork(String descriptionOfWork) {
		this.descriptionOfWork = descriptionOfWork;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String toString() {
		return descriptionOfWork+" "+category;
	}
	
  }


