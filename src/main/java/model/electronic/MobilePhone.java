package model.electronic;

public class MobilePhone extends Electronic {

	private int id;
	private String RAM;
	private String processorType;
	private String storageCapacity;
	private String mobileCableType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRAM() {
		return RAM;
	}
	public void setRAM(String rAM) {
		RAM = rAM;
	}
	public String getProcessorType() {
		return processorType;
	}
	public void setProcessorType(String processorType) {
		this.processorType = processorType;
	}
	public String getStorageCapacity() {
		return storageCapacity;
	}
	public void setStorageCapacity(String storageCapacity) {
		this.storageCapacity = storageCapacity;
	}
	public String getMobileCableType() {
		return mobileCableType;
	}
	public void setMobileCableType(String mobileCableType) {
		this.mobileCableType = mobileCableType;
	}
	public MobilePhone(int id, String productName, String batteryCapacity, String warrantyDuration, String warrantyType,
			String condition, String screenSize, String brand, int id2, String rAM, String processorType,
			String storageCapacity, String mobileCableType) {
		super(id, productName, batteryCapacity, warrantyDuration, warrantyType, condition, screenSize, brand);
		id = id2;
		RAM = rAM;
		this.processorType = processorType;
		this.storageCapacity = storageCapacity;
		this.mobileCableType = mobileCableType;
	}
	public MobilePhone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MobilePhone(int id, String productName, String batteryCapacity, String warrantyDuration, String warrantyType,
			String condition, String screenSize, String brand) {
		super(id, productName, batteryCapacity, warrantyDuration, warrantyType, condition, screenSize, brand);
		// TODO Auto-generated constructor stub
	}

	
}