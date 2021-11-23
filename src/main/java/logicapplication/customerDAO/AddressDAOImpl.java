package logicapplication.customerDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.customer.Address;
import model.customer.Customer;

public class AddressDAOImpl implements AddressDAO{

	@Override
	public List<Address> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address get(int id) {
		try {
			PreparedStatement preparedStatement = con.
					prepareStatement("SELECT * FROM address\r\n"
							+ "WHERE ID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				Address address = new Address();
				address.setId(rs.getInt(1));
				address.setNumberHouse(rs.getString(2));
				address.setStreet(rs.getString(3));
				address.setDistrict(rs.getString(4));
				address.setCity(rs.getString(5));
				return address;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int add(Address t) {
		try {
			PreparedStatement preparedStatement = con.
					prepareStatement("INSERT INTO address (numberHouse, street, district, city) VALUES (? , ?, ?, ?);");
			preparedStatement.setString(1, t.getNumberHouse());
			preparedStatement.setString(2, t.getStreet());
			preparedStatement.setString(3, t.getDistrict());
			preparedStatement.setString(4, t.getCity());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement = con.
					prepareStatement("SELECT MAX(ID) FROM address;");
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				int addressID = rs.getInt(1);
				return addressID;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void update(Address t) {
		// TODO Auto-generated method stub
				try {
					PreparedStatement preparedStatement = con.
							prepareStatement("UPDATE address SET numberHouse = ? , street = ?, district = ?, city = ? WHERE ID = ?;");
					preparedStatement.setString(1, t.getNumberHouse());
					preparedStatement.setString(2, t.getStreet());
					preparedStatement.setString(3, t.getDistrict());
					preparedStatement.setString(4, t.getCity());
					preparedStatement.setInt(5, t.getId());
					System.out.println(preparedStatement);
					preparedStatement.executeUpdate();
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public void delete(Address t) {
		// TODO Auto-generated method stub
		
	}

}
