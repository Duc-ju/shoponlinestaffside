package model.book;

import java.util.List;

public class BookItem {

	private int id;
	private String barcode;
	private float prices;
	private String description;
	private String header;
	private List<String> image;
	private Book book;
	private float discount;
	public BookItem(int id, String barcode, float prices, String description, String header, List<String> image,
			Book book, float discount) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.prices = prices;
		this.description = description;
		this.header = header;
		this.image = image;
		this.book = book;
		this.discount = discount;
	}
	public BookItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
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
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public List<String> getImage() {
		return image;
	}
	public void setImage(List<String> image) {
		this.image = image;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	
}