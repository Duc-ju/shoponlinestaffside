package model.staff;

import model.customer.Account;
import model.customer.Address;
import model.customer.FullName;

public class ProcessOrderStaff extends Staff{
	private String techExpString;

	public ProcessOrderStaff(float salary, int age, String sex, int expYear, Account account, FullName fullName,
			Address address, String techExpString) {
		super(salary, age, sex, expYear, account, fullName, address);
		this.techExpString = techExpString;
	}

	public String getTechExpString() {
		return techExpString;
	}

	public void setTechExpString(String techExpString) {
		this.techExpString = techExpString;
	}
	
}
