package model.staff;

import model.customer.Account;
import model.customer.Address;
import model.customer.FullName;

public class ManagerStaff extends Staff{
	private String certificate;

	public ManagerStaff(float salary, int age, String sex, int expYear, Account account, FullName fullName,
			Address address, String certificate) {
		super(salary, age, sex, expYear, account, fullName, address);
		this.certificate = certificate;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	
}
