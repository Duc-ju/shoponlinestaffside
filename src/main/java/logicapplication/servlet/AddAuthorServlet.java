package logicapplication.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicapplication.bookDAO.AuthorDAOImpl;
import model.book.Author;

/**
 * Servlet implementation class AddAuthorServlet
 */
@WebServlet("/addauthor")
public class AddAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String biography = request.getParameter("biography");
		String mail = request.getParameter("mail");
		String address = request.getParameter("address");
		Author author = new Author(name, biography, mail, address);
		new AuthorDAOImpl().add(author);
		response.sendRedirect(request.getContextPath()+"/addbook");
	}

}
