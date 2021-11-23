package model.order;

public class Shipment {

	private int id;
	private String type;
	private float cost;
	private String address;
	public Shipment(String type, float cost, String address) {
		super();
		this.type = type;
		this.cost = cost;
		this.address = address;
	}
	public Shipment(int id, String type, float cost, String address) {
		super();
		this.id = id;
		this.type = type;
		this.cost = cost;
		this.address = address;
	}
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
}