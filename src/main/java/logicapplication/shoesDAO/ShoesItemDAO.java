package logicapplication.shoesDAO;

import java.util.List;

import logicapplication.baseDAO.BaseDAO;
import model.shoes.ShoesItem;

public interface ShoesItemDAO extends BaseDAO<ShoesItem>{
	List<ShoesItem> getListByHeader(String header);
}
