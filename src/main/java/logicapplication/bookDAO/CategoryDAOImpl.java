package logicapplication.bookDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.book.Category;

public class CategoryDAOImpl implements CategoryDAO{

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<>();
      	try {
             	PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM category;");
             	System.out.println(preparedStatement);
             	ResultSet rs = preparedStatement.executeQuery();

             	while (rs.next()) {
                   	int id = rs.getInt("ID");
                   	String name = rs.getString("Name");


                   	categories.add(new Category(id, name));
             	}
      	} catch (SQLException e) {
             	// TODO Auto-generated catch block
             	e.printStackTrace();
      	}
      	return categories;
	}

	@Override
	public Category get(int id) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM category WHERE ID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				return category;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int add(Category t) {
		try {
         	PreparedStatement preparedStatement = con
                      	.prepareStatement("INSERT INTO `category`" + "  (Name) VALUES " + " (?);");
         	preparedStatement.setString(1, t.getName());
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
	public void update(Category t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Category t) {
		// TODO Auto-generated method stub
		
	}
	
}
