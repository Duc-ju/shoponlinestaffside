package model.electronic;

import java.util.List;

public class ElectronicItem {

	private int id;
	private float prices;
	private String description;
	private List<String> image;
	private String header;
	private float discount;
	private Electronic electronic;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrices() {
		return prices;
	}
	public void setPrices(float prices) {
		this.prices = prices;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getImage() {
		return image;
	}
	public void setImage(List<String> image) {
		this.image = image;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public Electronic getElectronic() {
		return electronic;
	}
	public void setElectronic(Electronic electronic) {
		this.electronic = electronic;
	}
	public ElectronicItem(int id, float prices, String description, List<String> image, String header, float discount,
			Electronic electronic) {
		super();
		this.id = id;
		this.prices = prices;
		this.description = description;
		this.image = image;
		this.header = header;
		this.discount = discount;
		this.electronic = electronic;
	}
	public ElectronicItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}