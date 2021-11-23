package logicapplication.customerDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.customer.Address;
import model.customer.Customer;
import model.customer.FullName;

public class FullNameDAOImpl implements FullNameDAO{

	@Override
	public List<FullName> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FullName get(int id) {
		try {
			PreparedStatement preparedStatement = con.
					prepareStatement("SELECT * FROM fullname\r\n"
							+ "WHERE ID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				return new FullName(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int add(FullName t) {
		try {
			PreparedStatement preparedStatement = con.
					prepareStatement("INSERT INTO fullname (firstName, midName, lastName) VALUES (?, ?, ?);");
			preparedStatement.setString(1, t.getFirstName());
			preparedStatement.setString(2, t.getMidName());
			preparedStatement.setString(3, t.getLastName());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement = con.
					prepareStatement("SELECT MAX(ID) FROM fullname;");
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				int fullNameID = rs.getInt(1);
				return fullNameID;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void update(FullName t) {
		try {
			PreparedStatement preparedStatement = con.
					prepareStatement("UPDATE fullname SET firstName = ?, midName = ?, lastName = ? WHERE ID = ?;");
			preparedStatement.setString(1, t.getFirstName());
			preparedStatement.setString(2, t.getMidName());
			preparedStatement.setString(3, t.getLastName());
			preparedStatement.setInt(4, t.getId());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(FullName t) {
		// TODO Auto-generated method stub
		
	}
}
