package model.electronic;

public class Laptop extends Electronic {

	private int id;
	private String laptopType;
	private String storageType;
	private String weight;
	
	
	
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Laptop(int id, String laptopType, String storageType, String weight) {
		super();
		this.id = id;
		this.laptopType = laptopType;
		this.storageType = storageType;
		this.weight = weight;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLaptopType() {
		return laptopType;
	}
	public void setLaptopType(String laptopType) {
		this.laptopType = laptopType;
	}
	public String getStorageType() {
		return storageType;
	}
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}

	
}