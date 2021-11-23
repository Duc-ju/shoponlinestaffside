package logicapplication.bookDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.book.Book;
import model.book.*;

public class BookDAOImpl implements BookDAO{

	@Override
	public List<Book> getAll() {
		List<Book> books = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM book;");
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				int categoryID = rs.getInt("CategoryID");
				Category category = new CategoryDAOImpl().get(categoryID);

				int publisherID = rs.getInt("PublisherID");
				Publisher publisher = new PublisherDAOImpl().get(publisherID);

				int authorID = rs.getInt("AuthorID");
				Author author = new AuthorDAOImpl().get(authorID);

				String IBSN = rs.getString("IBSN");
				String title = rs.getString("Title");
				String language = rs.getString("Language");
				Date publicationDate = rs.getDate("PublicationDate");
				int numberOfPage = rs.getInt("NumberOfPage");

				books.add(new Book(id, IBSN, title, language, publicationDate, numberOfPage, author, category,
						publisher));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book get(int id) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM book WHERE ID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt(1));

				int categoryID = rs.getInt(2);
				book.setCategory(new CategoryDAOImpl().get(categoryID));

				int publisherID = rs.getInt(3);
				book.setPublisher(new PublisherDAOImpl().get(publisherID));

				int authorID = rs.getInt(4);
				book.setAuthor(new AuthorDAOImpl().get(authorID));

				book.setIBSN(rs.getString(5));
				book.setTitle(rs.getString(6));
				book.setLanguage(rs.getString(7));
				book.setPublicationDate(rs.getDate(8));
				book.setNumberOfPage(rs.getInt(9));

				return book;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int add(Book t) {
		try {
         	PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO `book`"
                      	+ "  (CategoryID, PublisherID, AuthorID, IBSN, Title, Language, PublicationDate, NumberOfPage) VALUES "
                      	+ " (?, ?, ?, ?, ?, ?, ?, ?);");
         	preparedStatement.setInt(1, t.getCategory().getId());
         	preparedStatement.setInt(2, t.getPublisher().getId());
         	preparedStatement.setInt(3, t.getAuthor().getId());
         	preparedStatement.setString(4, t.getIBSN());
         	preparedStatement.setString(5, t.getTitle());
         	preparedStatement.setString(6, t.getLanguage());
         	preparedStatement.setDate(7,  t.getPublicationDate());
         	preparedStatement.setInt(8, t.getNumberOfPage());

         	System.out.println(preparedStatement);
         	preparedStatement.executeUpdate();
         	try {
               	PreparedStatement preparedStatement1 = con.prepareStatement("SELECT MAX(ID) FROM `book`;");
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
	public void update(Book t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Book t) {
		// TODO Auto-generated method stub
		
	}

}
