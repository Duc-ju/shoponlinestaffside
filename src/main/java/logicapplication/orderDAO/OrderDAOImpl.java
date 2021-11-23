package logicapplication.orderDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import logicapplication.customerDAO.CustomerDAO;
import logicapplication.customerDAO.CustomerDAOImpl;
import model.customer.Customer;
import model.order.Cart;
import model.order.Order;
import model.order.Payment;
import model.order.Shipment;

public class OrderDAOImpl implements OrderDAO{

	@Override
	public List<Order> getAll() {
		List<Order> list = new ArrayList<Order>();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("SELECT ID FROM `order` WHERE Status!='new'");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				list.add(get(rs.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		list.sort(new Comparator<Order>() {

			@Override
			public int compare(Order o1, Order o2) {
				if(o1.getStatus().equals("process")) return -1;
				if(o2.getStatus().equals("process")) return 1;
				if(o1.getStatus().equals("confirm")) return -1;
				if(o2.getStatus().equals("confirm")) return 1;
				if(o1.getStatus().equals("complete")) return -1;
				if(o2.getStatus().equals("complete")) return 1;
				if(o1.getStatus().equals("cancel")) return -1;
				if(o2.getStatus().equals("cancel")) return 1;
				return 0;
				
			}

			
		});
		return list;
	}
	public List<Order> getAll(int CustomerID) {
		List<Order> list = new ArrayList<Order>();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("SELECT ID FROM `order` WHERE CustomerID =? AND Status!='new'");
			preparedStatement.setInt(1, CustomerID);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				list.add(get(rs.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		list.sort(new Comparator<Order>() {

			@Override
			public int compare(Order o1, Order o2) {
				if(o1.getStatus().equals("process")) return -1;
				if(o2.getStatus().equals("process")) return 1;
				if(o1.getStatus().equals("confirm")) return -1;
				if(o2.getStatus().equals("confirm")) return 1;
				if(o1.getStatus().equals("complete")) return -1;
				if(o2.getStatus().equals("complete")) return 1;
				if(o1.getStatus().equals("cancel")) return -1;
				if(o2.getStatus().equals("cancel")) return 1;
				return 0;
			}
		});
		return list;
	}

	@Override
	public int add(Order t) {
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("INSERT INTO `order` (CustomerID, Status) VALUES (?,?);");

			preparedStatement.setInt(1, t.getCustomer().getId());
			preparedStatement.setString(2, "new");

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			try {
				PreparedStatement preparedStatement1 = con.prepareStatement("SELECT MAX(ID) FROM `order`;");
				System.out.println(preparedStatement1);
				ResultSet rs1 = preparedStatement1.executeQuery();
				if(rs1.next()) {
					return rs1.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void update(Order t) {
		
	}

	@Override
	public void delete(Order t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCart(Cart c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStatus(Order o) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement("UPDATE `order` SET Status = ? WHERE ID = ?");

			preparedStatement.setString(1, o.getStatus());
			preparedStatement.setInt(2, o.getId());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getLastOrderID(int CustomerID) {
		String select = "Select * from `order` where CustomerID=? and Status='new'";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(select);
			preparedStatement.setInt(1, CustomerID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt("ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	@Override
	public Order get(int id) {
		String selectOrder = "select * from `order` where id = ?";
		String selectShipment = "select * from shipment where OrderID = ?";
		String selectPayment = "select * from payment where OrderID = ?";
		String selectCart = "select * from cart where OrderID = ?";
		String selectVoucher = "select * from voucher where OrderID = ?";
		Order order = new Order();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement(selectOrder);
			preparedStatement.setInt(1, id);
			ResultSet resultSetOrder = preparedStatement.executeQuery();
			if(resultSetOrder.next()) {
				order.setId(resultSetOrder.getInt("ID"));
				order.setStatus(resultSetOrder.getString("Status"));
			}
			CustomerDAO customerDAO = new CustomerDAOImpl();
			Customer customer = customerDAO.get(resultSetOrder.getInt("CustomerID"));
			order.setCustomer(customer);
			preparedStatement = con.prepareStatement(selectShipment);
			preparedStatement.setInt(1, id);
			ResultSet resultSetShipment = preparedStatement.executeQuery();
			Shipment shipment = null;
			if(resultSetShipment.next()) {
				//int id, String type, float cost, String address
				 shipment = new Shipment(resultSetShipment.getInt("ID"),
						resultSetShipment.getString("Type"),
						resultSetShipment.getFloat("Cost"),
						resultSetShipment.getString("Address"));
			}
			order.setShipment(shipment);
			preparedStatement = con.prepareStatement(selectPayment);
			preparedStatement.setInt(1, id);
			ResultSet resultSetPayment = preparedStatement.executeQuery();
			Payment payment = null;
			if(resultSetPayment.next()) {
				//int id, String type, float totalAmount
				 payment = new Payment(resultSetPayment.getInt("ID"),
						resultSetPayment.getString("Type"),
						resultSetPayment.getFloat("TotalAmount"));
				order.setTotalAmount(resultSetPayment.getFloat("TotalAmount"));
			}
			order.setPayment(payment);
			preparedStatement = con.prepareStatement(selectCart);
			preparedStatement.setInt(1, id);
			ResultSet resultSetCart = preparedStatement.executeQuery();
			Cart cart = null;
			if(resultSetCart.next()) {
				int idCart = resultSetCart.getInt("ID");
				CartDAO cartDAO = new CartDAOImpl();
				cart = cartDAO.get(idCart);
			}
			order.setCart(cart);
			order.setTotalAmount(shipment.getCost()+cart.getTotalPrice());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
}
