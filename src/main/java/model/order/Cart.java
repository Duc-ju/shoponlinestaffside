package model.order;

import java.util.List;

import model.book.*;
import model.clothes.*;
import model.electronic.*;
import model.shoes.*;

public class Cart {

	private int id;
	private int quanity;
	private float totalPrice;
	private List<BookItem> bookItems;
	private List<ClothesItem> clothesItems;
	private List<ElectronicItem> elctronicItems;
	private List<ShoesItem> shoesItems;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuanity() {
		return quanity;
	}
	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<BookItem> getBookItems() {
		return bookItems;
	}
	public void setBookItems(List<BookItem> bookItems) {
		this.bookItems = bookItems;
	}
	public List<ClothesItem> getClothesItems() {
		return clothesItems;
	}
	public void setClothesItems(List<ClothesItem> clothesItems) {
		this.clothesItems = clothesItems;
	}
	public List<ElectronicItem> getElctronicItems() {
		return elctronicItems;
	}
	public void setElctronicItems(List<ElectronicItem> elctronicItems) {
		this.elctronicItems = elctronicItems;
	}
	public List<ShoesItem> getShoesItems() {
		return shoesItems;
	}
	public void setShoesItems(List<ShoesItem> shoesItems) {
		this.shoesItems = shoesItems;
	}
	public Cart(int id, int quanity, float totalPrice, List<BookItem> bookItems, List<ClothesItem> clothesItems,
			List<ElectronicItem> elctronicItems, List<ShoesItem> shoesItems) {
		super();
		this.id = id;
		this.quanity = quanity;
		this.totalPrice = totalPrice;
		this.bookItems = bookItems;
		this.clothesItems = clothesItems;
		this.elctronicItems = elctronicItems;
		this.shoesItems = shoesItems;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}