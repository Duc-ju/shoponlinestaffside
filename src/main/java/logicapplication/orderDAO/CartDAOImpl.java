package logicapplication.orderDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logicapplication.bookDAO.BookItemDAOImpl;
import logicapplication.electonicDAO.ElectronicItemDAOImpl;
import model.book.BookItem;
import model.clothes.ClothesItem;
import model.customer.Account;
import model.customer.Customer;
import model.electronic.ElectronicItem;
import model.order.Cart;
import model.shoes.ShoesItem;

public class CartDAOImpl implements CartDAO{

	@Override
	public List<Cart> getAll() {
		return null;
		
	}

	@Override
	public Cart get(int id) {
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("SELECT * FROM cart where ID=?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			Cart cart = new Cart();
			if(rs.next()) {
				cart.setId(rs.getInt(1));
				cart.setBookItems(new CartDAOImpl().getBookItems(cart.getId()));
				cart.setElctronicItems(new CartDAOImpl().getElectronicItems(cart.getId()));
				//shoes
				//clothes
				cart.setQuanity(cart.getBookItems().size()+cart.getElctronicItems().size());
				float total = 0;
				for(BookItem bookItem : cart.getBookItems()) {
					total+=bookItem.getPrices();
				}
				for(ElectronicItem electronicItem : cart.getElctronicItems()) {
					total+=electronicItem.getPrices();
				}
				cart.setTotalPrice(total);
				return cart;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int add(Cart t) {
		try {
        	PreparedStatement preparedStatement = con.
    				prepareStatement("INSERT INTO `cart` (PaymentID, OrderID) VALUES (null,null)");

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            try {
    			PreparedStatement preparedStatement1 = con.
    					prepareStatement("SELECT MAX(ID) FROM cart");
    			System.out.println(preparedStatement1);
    			ResultSet rs1 = preparedStatement1.executeQuery();
    			if(rs1.next()) {
					return rs1.getInt(1);
				}
    			return rs1.getInt(1);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return 0;
	}

	@Override
	public void update(Cart t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cart t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOrderID(int CartID, int orderID) {
		try {
        	PreparedStatement preparedStatement = con.
    				prepareStatement("UPDATE `cart` SET OrderID = ? WHERE ID = ?");
            
        	preparedStatement.setInt(1, orderID);
            preparedStatement.setInt(2, CartID);

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	
        	e.printStackTrace();
        }
	}

	@Override
	public void addBookItem(int itemID, int cartID) {
		try {

			PreparedStatement preparedStatement = con
					.prepareStatement("INSERT INTO cart_bookitem(CartID, BookItemID) " + "VALUES (?, ?);");
			preparedStatement.setInt(1, cartID);
			preparedStatement.setInt(2, itemID);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addElectronicItem(int itemID, int cartID) {
		try {

			PreparedStatement preparedStatement = con
					.prepareStatement("INSERT INTO cart_electronicitem(CartID, ElectronicItemID) " + "VALUES (?, ?);");
			preparedStatement.setInt(1, cartID);
			preparedStatement.setInt(2, itemID);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addShoesItem(int itemID, int cartID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addClothesItem(int itemID, int cartID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BookItem> getBookItems(int id) {
		List<BookItem> bookItems = new ArrayList<BookItem>();
		try {

			PreparedStatement preparedStatement = con
					.prepareStatement("SELECT BookItemID FROM cart_bookitem WHERE CartID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				bookItems.add(new BookItemDAOImpl().get(rs.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookItems;
	}

	@Override
	public List<ElectronicItem> getElectronicItems(int id) {
		List<ElectronicItem> electronicItems = new ArrayList<ElectronicItem>();
		try {

			PreparedStatement preparedStatement = con
					.prepareStatement("SELECT ElectronicItemID FROM cart_electronicitem WHERE CartID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				electronicItems.add(new ElectronicItemDAOImpl().get(rs.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return electronicItems;
	}
	@Override
	public List<ShoesItem> getShoesItems(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClothesItem> getClothesItems(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBookItem(int itemID, int cartID) {
		try {

			PreparedStatement preparedStatement = con
					.prepareStatement("DELETE FROM cart_bookitem WHERE CartID = ? AND BookItemID = ?;");
			preparedStatement.setInt(1, cartID);
			preparedStatement.setInt(2, itemID);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteElectronicItem(int itemID, int cartID) {
		try {

			PreparedStatement preparedStatement = con
					.prepareStatement("DELETE FROM cart_electronicitem WHERE CartID = ? AND ElectronicItemID = ?;");
			preparedStatement.setInt(1, cartID);
			preparedStatement.setInt(2, itemID);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteShoesItem(int itemID, int cartID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClothesItem(int itemID, int cartID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cart getCurrentCart(int customerID) {
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("SELECT * FROM `cart` WHERE OrderID IN(\r\n"
							+ "	SELECT ID from `order`\r\n"
							+ "    WHERE CustomerID = ?\r\n"
							+ "    AND `Status`='new'\r\n"
							+ ")");
			preparedStatement.setInt(1, customerID);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			Cart cart = new Cart();
			if(rs.next()) {
				cart.setId(rs.getInt(1));
				cart.setBookItems(new CartDAOImpl().getBookItems(cart.getId()));
				cart.setElctronicItems(new CartDAOImpl().getElectronicItems(cart.getId()));
				//shoes
				//clothes
				cart.setQuanity(cart.getBookItems().size()+cart.getElctronicItems().size());
				float total = 0;
				for(BookItem bookItem : cart.getBookItems()) {
					total+=bookItem.getPrices();
				}
				for(ElectronicItem electronicItem : cart.getElctronicItems()) {
					total+=electronicItem.getPrices();
				}
				cart.setTotalPrice(total);
				return cart;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void setPaymentID(int PaymentID, int CartID) {
		try {
        	PreparedStatement preparedStatement = con.
    				prepareStatement("UPDATE `cart` SET PaymentID = ? WHERE ID = ?");
            
        	preparedStatement.setInt(1, PaymentID);
            preparedStatement.setInt(2, CartID);

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	
        	e.printStackTrace();
        }
	}
}
