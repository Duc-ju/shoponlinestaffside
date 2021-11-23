package model.electronic;

public class Tablet extends Electronic {

	private boolean eReader;
	private String storageCapacity;
	private int id;
	public Tablet(int id, String productName, String batteryCapacity, String warrantyDuration, String warrantyType,
			String condition, String screenSize, String brand, boolean eReader, String storageCapacity, int id2) {
		super(id, productName, batteryCapacity, warrantyDuration, warrantyType, condition, screenSize, brand);
		this.eReader = eReader;
		this.storageCapacity = storageCapacity;
		id = id2;
	}
	public Tablet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tablet(int id, String productName, String batteryCapacity, String warrantyDuration, String warrantyType,
			String condition, String screenSize, String brand) {
		super(id, productName, batteryCapacity, warrantyDuration, warrantyType, condition, screenSize, brand);
		// TODO Auto-generated constructor stub
	}
	public boolean iseReader() {
		return eReader;
	}
	public void seteReader(boolean eReader) {
		this.eReader = eReader;
	}
	public String getStorageCapacity() {
		return storageCapacity;
	}
	public void setStorageCapacity(String storageCapacity) {
		this.storageCapacity = storageCapacity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}