package logicapplication.customerDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.customer.FullName;
import model.order.Order;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer get(int id) {
		try {
			PreparedStatement preparedStatement = con.
					prepareStatement("SELECT * FROM customer\r\n"
							+ "WHERE ID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			Customer customer = new Customer();
			if(rs.next()) {
				customer.setId(rs.getInt(1));
				customer.setPhone(rs.getString(2));
				customer.setMail(rs.getString(3));
				customer.setImage(rs.getString(4));
				customer.setSex(rs.getString(5));
				customer.setAccount(new AccountDAOImpl().get(rs.getInt(6)));
				customer.setAddress(new AddressDAOImpl().get(rs.getInt(7)));
				customer.setFullName(new FullNameDAOImpl().get(rs.getInt(8)));
			}
			return customer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int add(Customer t) {
		try {
			PreparedStatement preparedStatement = con.
					prepareStatement("INSERT INTO Customer (Phone, Mail,AccountID) VALUES (?, ? ,?);");
			preparedStatement.setString(1, t.getPhone());
			preparedStatement.setString(2, t.getMail());
			preparedStatement.setInt(3, t.getAccount().getId());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement = con.
					prepareStatement("SELECT MAX(ID) FROM Customer;");
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				int customerID = rs.getInt(1);
				return customerID;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void update(Customer t) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement(
					"UPDATE customer SET Phone = ?, Mail = ?, Image = ?, Sex = ? WHERE ID = ?");
			preparedStatement.setString(1, t.getPhone());
			preparedStatement.setString(2, t.getMail());
			preparedStatement.setString(3, t.getImage());
			preparedStatement.setString(4, t.getSex());
			
			preparedStatement.setInt(5, t.getId());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Customer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewOrder(Order o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer get(Customer customer) {
		try {
			PreparedStatement preparedStatement = con.
					prepareStatement("SELECT * FROM customer\r\n"
							+ "WHERE AccountID = ?");
			preparedStatement.setInt(1, customer.getAccount().getId());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				customer.setId(rs.getInt(1));
				customer.setPhone(rs.getString(2));
				customer.setMail(rs.getString(3));
				customer.setImage(rs.getString(4));
				customer.setSex(rs.getString(5));
				customer.setAccount(new AccountDAOImpl().get(rs.getInt(6)));
				customer.setAddress(new AddressDAOImpl().get(rs.getInt(7)));
				customer.setFullName(new FullNameDAOImpl().get(rs.getInt(8)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public void setFullNameId(int fullNameID, int customerID) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = con.
					prepareStatement("UPDATE customer SET fullNameID = ? WHERE ID = ?;");
			preparedStatement.setInt(1, fullNameID);
			preparedStatement.setInt(2, customerID);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setAddressId(int addressID, int customerID) {
		// TODO Auto-generated method stub
				try {
					PreparedStatement preparedStatement = con.
							prepareStatement("UPDATE customer SET addressID = ? WHERE ID = ?;");
					preparedStatement.setInt(1, addressID);
					preparedStatement.setInt(2, customerID);
					System.out.println(preparedStatement);
					preparedStatement.executeUpdate();
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
