package logicapplication.bookDAO;

import java.util.List;

import logicapplication.baseDAO.BaseDAO;
import model.book.BookItem;

public interface BookItemDAO extends BaseDAO<BookItem>{
	List<BookItem> getListByHeader(String header);
}
