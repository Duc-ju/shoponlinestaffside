package logicapplication.customerDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.customer.Account;
import model.customer.Customer;

public class AccountDAOImpl implements AccountDAO{

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account get(int id) {
		try {
			
			PreparedStatement preparedStatement = con.
					prepareStatement("select * from account where id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return new Account(resultSet.getInt("ID"),
						resultSet.getString("Username"),
						resultSet.getString("Password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int add(Account t) {
		try {
			
			PreparedStatement preparedStatement = con.
					prepareStatement("INSERT INTO Account(username, password) " 
							 + "VALUES (?, ?);");
			preparedStatement.setString(1, t.getUsername());
			preparedStatement.setString(2, t.getPassword());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			Account account = checkAccount(t);
			return account.getId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void update(Account t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = con.prepareStatement("UPDATE Account SET password = ? WHERE ID = ?;");
			preparedStatement.setString(1, t.getPassword());
			preparedStatement.setInt(2, t.getId());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Account t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account checkAccount(Account account) {
		try {
			PreparedStatement preparedStatement = con.
					prepareStatement("SELECT * FROM Account\r\n"
							+ "WHERE username = ?\r\n"
							+ "AND passWord = ?");
			preparedStatement.setString(1, account.getUsername());
			preparedStatement.setString(2, account.getPassword());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				account.setId(rs.getInt(1));
				return account;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean checkDuplicatedName(String username) {
		try {
			PreparedStatement preparedStatement = con.
					prepareStatement("SELECT * FROM Account\r\n"
							+ "WHERE username = ?\r\n");
			preparedStatement.setString(1, username);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			Customer customer = new Customer();
			if(rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
		
//	public static void main (String[] args) {
//		ConnectDB.openConnect();
////		System.out.println(new AccountDAOImpl().add(new Account("khanh1","khanh1")));
//		System.out.println(new AccountDAOImpl().checkDuplicatedName("khanh2"));
//	}

}
