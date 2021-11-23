package logicapplication.clothesDAO;

import java.util.List;

import logicapplication.baseDAO.BaseDAO;
import model.clothes.Clothes;

public interface ClothesItemDAO extends BaseDAO<Clothes>{
	List<Clothes> getListByHeader(String header);
}
