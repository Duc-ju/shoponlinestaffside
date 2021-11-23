package logicapplication.orderDAO;

import java.util.List;

import logicapplication.baseDAO.BaseDAO;
import model.book.BookItem;
import model.clothes.ClothesItem;
import model.electronic.ElectronicItem;
import model.order.Cart;
import model.shoes.ShoesItem;

public interface CartDAO extends BaseDAO<Cart>{
	void setPaymentID(int ShipmentID, int CartID);
	Cart getCurrentCart(int customerID);
	void setOrderID(int CartID, int orderID);
	void addBookItem(int itemID, int cartID);
	void addElectronicItem(int itemID, int cartID);
	void addShoesItem(int itemID, int cartID);
	void addClothesItem(int itemID, int cartID);
	void deleteBookItem(int itemID, int cartID);
	void deleteElectronicItem(int itemID, int cartID);
	void deleteShoesItem(int itemID, int cartID);
	void deleteClothesItem(int itemID, int cartID);
	List<BookItem> getBookItems(int id);
	List<ElectronicItem> getElectronicItems(int id);
	List<ShoesItem> getShoesItems(int id);
	List<ClothesItem> getClothesItems(int id);
}
