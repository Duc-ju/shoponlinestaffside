package logicapplication.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicapplication.bookDAO.AuthorDAOImpl;
import logicapplication.bookDAO.BookDAOImpl;
import logicapplication.bookDAO.CategoryDAOImpl;
import logicapplication.bookDAO.PublisherDAOImpl;
import model.book.Author;
import model.book.Category;
import model.book.Publisher;
import model.book.*;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addbook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = new CategoryDAOImpl().getAll();
		List<Author> authors = new AuthorDAOImpl().getAll();
		List<Publisher> publishers = new PublisherDAOImpl().getAll();
		request.setAttribute("categories", categories);
		request.setAttribute("authors", authors);
		request.setAttribute("publishers", publishers);
		request.getRequestDispatcher("BookForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int AuthorID = Integer.parseInt(request.getParameter("author"));
		int PublisherID = Integer.parseInt(request.getParameter("publisher"));
		int CategoryID = Integer.parseInt(request.getParameter("category"));
		String ISBN = request.getParameter("ISBN");
		String title = request.getParameter("title");
		String language = request.getParameter("language");
		Date publicationDate = Date.valueOf(request.getParameter("publicationDate"));
		int numberOfPage = Integer.parseInt(request.getParameter("numberOfPage"));
		Author author = new Author();
		author.setId(AuthorID);
		Publisher publisher = new Publisher();
		publisher.setId(PublisherID);
		Category category = new Category();
		category.setId(CategoryID);
		Book book = new Book(ISBN, title, language, publicationDate, numberOfPage, author, category, publisher);
		new BookDAOImpl().add(book);
	}

}
