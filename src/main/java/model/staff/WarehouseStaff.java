package model.staff;

import model.customer.Account;
import model.customer.Address;
import model.customer.FullName;

public class WarehouseStaff extends Staff{
	private int storageNum;

	public WarehouseStaff(float salary, int age, String sex, int expYear, Account account, FullName fullName,
			Address address, int storageNum) {
		super(salary, age, sex, expYear, account, fullName, address);
		this.storageNum = storageNum;
	}

	public int getStorageNum() {
		return storageNum;
	}

	public void setStorageNum(int storageNum) {
		this.storageNum = storageNum;
	}
	
}
