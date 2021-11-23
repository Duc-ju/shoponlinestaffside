package model.electronic;

public class Electronic {

	private int id;
	private String productName;
	private String batteryCapacity;
	private String warrantyDuration;
	private String warrantyType;
	private String Condition;
	private String screenSize;
	private String brand;
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	public String getWarrantyDuration() {
		return warrantyDuration;
	}
	public void setWarrantyDuration(String warrantyDuration) {
		this.warrantyDuration = warrantyDuration;
	}
	public String getWarrantyType() {
		return warrantyType;
	}
	public void setWarrantyType(String warrantyType) {
		this.warrantyType = warrantyType;
	}
	public String getCondition() {
		return Condition;
	}
	public void setCondition(String condition) {
		Condition = condition;
	}
	public String getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Electronic(int id, String productName, String batteryCapacity, String warrantyDuration, String warrantyType,
			String condition, String screenSize, String brand) {
		super();
		this.id = id;
		this.productName = productName;
		this.batteryCapacity = batteryCapacity;
		this.warrantyDuration = warrantyDuration;
		this.warrantyType = warrantyType;
		Condition = condition;
		this.screenSize = screenSize;
		this.brand = brand;
	}
	public Electronic() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}