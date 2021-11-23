package logicapplication.bookDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.book.Author;

public class AuthorDAOImpl implements AuthorDAO{

	@Override
	public List<Author> getAll() {
		List<Author> authors = new ArrayList<>();
      	try {
             	PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM author;");
             	System.out.println(preparedStatement);
             	ResultSet rs = preparedStatement.executeQuery();

             	while (rs.next()) {
                   	int id = rs.getInt("ID");
                   	String name = rs.getString("Name");
                   	String biography = rs.getString("Biography");
                   	String email = rs.getString("Email");
                   	String address = rs.getString("Address");


                   	authors.add(new Author(id, name, biography, email, address));
             	}
      	} catch (SQLException e) {
             	// TODO Auto-generated catch block
             	e.printStackTrace();
      	}
      	return authors;
	}

	@Override
	public Author get(int id) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM author WHERE ID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				Author author = new Author();
				author.setId(rs.getInt(1));
				author.setName(rs.getString(2));
				author.setBiography(rs.getString(3));
				author.setEmail(rs.getString(4));
				author.setAddress(rs.getString(5));
				return author;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int add(Author t) {
		try {
         	PreparedStatement preparedStatement = con.prepareStatement(
                      	"INSERT INTO `author`" + "  (Name, Biography, Email, Address) VALUES " + " (?, ?, ?, ?);");
         	preparedStatement.setString(1, t.getName());
         	preparedStatement.setString(2, t.getBiography());
         	preparedStatement.setString(3, t.getEmail());
         	preparedStatement.setString(4, t.getAddress());

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
	public void update(Author t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Author t) {
		// TODO Auto-generated method stub
		
	}

}
