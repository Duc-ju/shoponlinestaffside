package model.order;

public class Voucher {

	private int id;
	private String name;
	private float discountPercent;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Voucher(int id, String name, float discountPercent, String description) {
		super();
		this.id = id;
		this.name = name;
		this.discountPercent = discountPercent;
		this.description = description;
	}
	public Voucher() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}