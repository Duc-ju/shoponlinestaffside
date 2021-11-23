package model.order;

import java.util.Date;

public class Credit extends Payment {

	private String number;
	private String type;
	private Date exDate;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getExDate() {
		return exDate;
	}
	public void setExDate(Date exDate) {
		this.exDate = exDate;
	}
	public Credit(String number, String type, Date exDate) {
		super();
		this.number = number;
		this.type = type;
		this.exDate = exDate;
	}
	public Credit() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}