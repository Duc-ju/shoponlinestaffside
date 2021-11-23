package model.staff;

import model.customer.Account;
import model.customer.Address;
import model.customer.FullName;

public class PutItemStaff extends Staff{
	private String seoExp;

	public String getSeoExp() {
		return seoExp;
	}

	public void setSeoExp(String seoExp) {
		this.seoExp = seoExp;
	}

	public PutItemStaff(float salary, int age, String sex, int expYear, Account account, FullName fullName,
			Address address, String seoExp) {
		super(salary, age, sex, expYear, account, fullName, address);
		this.seoExp = seoExp;
	}
	
}
