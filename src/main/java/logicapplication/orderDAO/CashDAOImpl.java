package logicapplication.orderDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.order.Cash;
import model.order.Order;
import model.order.Shipment;

public class CashDAOImpl implements CashDAO{

	
	
	public void setID(int ID_Cash, int 	ID_Order) {
		String update = "update payment set OrderID = ? where ID = ?";
		try {
            PreparedStatement ps = con.prepareStatement(update);
            ps.setInt(1, ID_Order);
            ps.setInt(2, ID_Cash);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}

	@Override
	public void getOrder(Order o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getShipment(Shipment s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cash> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cash get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Cash t) {
		// TODO Auto-generated method stub
		String insertPaymen = "insert into payment(Type, TotalAmount)"
				+ "values(?,?)";
		String insertCash = "insert into cash(Cashier, CashTendered, PaymentID) values(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(insertPaymen, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getType());
            ps.setFloat(2, t.getTotalAmount());
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            if(result.next()){
                t.setId(result.getInt(1));
            }
            ps = con.prepareStatement(insertCash);
            ps.setString(1, t.getCashier());
            ps.setFloat(2, t.getTotalAmount());
            ps.setInt(3, t.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return t.getId();
	}

	@Override
	public void update(Cash t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cash t) {
		// TODO Auto-generated method stub
		
	}

}
