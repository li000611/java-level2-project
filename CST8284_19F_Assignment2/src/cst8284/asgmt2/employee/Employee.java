package cst8284.asgmt2.employee;
/*Course Name: CST8284_302
 * Student Name: Min Li
 * Class Name:  Employee
 * Date:  2019-10-26
 */

public abstract class Employee {
	private String fullName;
	
	protected Employee() {
		this("unknown");
		}
	
	protected Employee(String name) {
		setName(name);
		}
	
	public void setName(String name) {
		this.fullName  = name;
		}
	
	public String getName() {
		return fullName;
		}
	
	public abstract String getActivityType();
	
	@Override
	public String toString() {return getName();}
	
}