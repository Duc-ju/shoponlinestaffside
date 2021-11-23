package model.staff;

import model.customer.Account;
import model.customer.Address;
import model.customer.FullName;

public class Staff {
	private float salary;
	private int age;
	private String sex;
	private int expYear;
	private Account account;
	private FullName fullName;
	private Address address;
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getExpYear() {
		return expYear;
	}
	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public FullName getFullName() {
		return fullName;
	}
	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Staff(float salary, int age, String sex, int expYear, Account account, FullName fullName, Address address) {
		super();
		this.salary = salary;
		this.age = age;
		this.sex = sex;
		this.expYear = expYear;
		this.account = account;
		this.fullName = fullName;
		this.address = address;
	}
	
}
