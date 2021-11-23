package logicapplication.bookDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.book.Publisher;

public class PublisherDAOImpl implements PublisherDAO {

	@Override
	public List<Publisher> getAll() {
		List<Publisher> publishers = new ArrayList<Publisher>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM publisher");
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Publisher publisher = new Publisher();
				publisher.setId(rs.getInt(1));
				publisher.setName(rs.getString(2));
				publisher.setAddress(rs.getString(3));
				publishers.add(publisher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return publishers;
	}

	@Override
	public Publisher get(int id) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM publisher WHERE ID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				Publisher publisher = new Publisher();
				publisher.setId(rs.getInt(1));
				publisher.setName(rs.getString(2));
				publisher.setAddress(rs.getString(3));
				return publisher;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int add(Publisher t) {
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("INSERT INTO `publisher`" + "  (Name, Address) VALUES " + " (?, ?);");
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getAddress());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			try {
				PreparedStatement preparedStatement1 = con.prepareStatement("SELECT MAX(ID) FROM `author`;");
				System.out.println(preparedStatement1);
				ResultSet rs1 = preparedStatement1.executeQuery();
				if (rs1.next()) {
					return rs1.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void update(Publisher t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Publisher t) {
		// TODO Auto-generated method stub

	}

}
