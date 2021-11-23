package model.customer;

import java.util.List;

import model.order.*;

public class Customer {

	private int id;
	private String phone;
	private String mail;
	private Account account;
	private Address address;
	private FullName fullName;
	private String image;
	private String sex;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(String phone, String mail) {
		super();
		this.phone = phone;
		this.mail = mail;
	}

	
	
	public Customer(int id, String phone, String mail, Account account, Address address, FullName fullName) {
		super();
		this.id = id;
		this.phone = phone;
		this.mail = mail;
		this.account = account;
		this.address = address;
		this.fullName = fullName;
	}



	public Customer(String phone, String mail, Account account) {
		super();
		this.phone = phone;
		this.mail = mail;
		this.account = account;
	}




	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public FullName getFullName() {
		return fullName;
	}
	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
	
}