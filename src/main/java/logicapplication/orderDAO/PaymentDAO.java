package logicapplication.orderDAO;

import logicapplication.baseDAO.BaseDAO;
import model.order.Order;
import model.order.Shipment;

public interface PaymentDAO{
	void getOrder(Order o);
	void getShipment(Shipment s);
}
