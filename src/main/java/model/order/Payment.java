package model.order;

public class Payment {

	private int id;
	private String type;
	private float totalAmount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Payment(int id, String type, float totalAmount) {
		super();
		this.id = id;
		this.type = type;
		this.totalAmount = totalAmount;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}