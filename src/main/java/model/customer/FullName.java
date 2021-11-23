package model.customer;

public class FullName {

	private int id;
	private String firstName;
	private String midName;
	private String lastName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMidName() {
		return midName;
	}
	public void setMidName(String midName) {
		this.midName = midName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public FullName(int id, String firstName, String midName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
	}
	public FullName() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return firstName + " " +midName +" "+lastName;
	}
}