package logicapplication.orderDAO;

import java.util.List;

import logicapplication.baseDAO.BaseDAO;
import model.customer.Customer;
import model.order.Cart;
import model.order.Order;

public interface OrderDAO extends BaseDAO<Order>{
	void getCustomer(Customer c);
	void getCart(Cart c);
	void updateStatus(Order o);
	int getLastOrderID(int CustomerID);
	public List<Order> getAll(int CustomerID);
}
