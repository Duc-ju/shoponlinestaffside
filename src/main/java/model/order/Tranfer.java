package model.order;

public class Tranfer extends Payment {

	private String name;
	private String bankID;
	public Tranfer(int id, String type, float totalAmount, String name, String bankID) {
		super(id, type, totalAmount);
		this.name = name;
		this.bankID = bankID;
	}
	public Tranfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tranfer(int id, String type, float totalAmount) {
		super(id, type, totalAmount);
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBankID() {
		return bankID;
	}
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	
}