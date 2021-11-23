package model.order;

public class Cash extends Payment {

	private String cashier;
	private float cashTendered;
	public Cash(String cashier, float cashTendered) {
		super();
		this.cashier = cashier;
		this.cashTendered = cashTendered;
	}
	public Cash() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCashier() {
		return cashier;
	}
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
	public float getCashTendered() {
		return cashTendered;
	}
	public void setCashTendered(float cashTendered) {
		this.cashTendered = cashTendered;
	}

	
}