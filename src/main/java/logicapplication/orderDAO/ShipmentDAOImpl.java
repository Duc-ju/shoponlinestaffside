package logicapplication.orderDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.order.Shipment;

public class ShipmentDAOImpl implements ShipmentDAO{

	@Override
	public List<Shipment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shipment get(int id) {
		// TODO Auto-generated method stub
		String selectString = "SELECT * FROM shipment WHERE id = ?";
		try {
            PreparedStatement ps = con.prepareStatement(selectString);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if(result.next()){
            	return new Shipment(result.getInt("ID"),
            			result.getString("Type"),
            			result.getFloat("Cost"),
            			result.getString("Address"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return null;
	}

	@Override
	public int add(Shipment t) {
		// TODO Auto-generated method stub
		String insert = "insert into shipment(Type, Cost, Address) values(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getType());
            ps.setFloat(2, t.getCost());
            ps.setString(3, t.getAddress());
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            if(result.next()){
                t.setId(result.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return t.getId();
	}

	@Override
	public void update(Shipment t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Shipment t) {
		// TODO Auto-generated method stub
		
	}

	public void setOrderID(int ID_Shipment, int ID_Order) {
		String updateString = "update shipment set OrderID = ? where ID = ?";
		try {
            PreparedStatement ps = con.prepareStatement(updateString);
            ps.setInt(1, ID_Order);
            ps.setFloat(2, ID_Shipment);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
	
	public void setPaymentID(int ID_Shipment, int ID_Payment) {
		String updateString = "update shipment set PaymentID = ? where ID = ?";
		try {
            PreparedStatement ps = con.prepareStatement(updateString);
            ps.setInt(1, ID_Payment);
            ps.setFloat(2, ID_Shipment);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
}
