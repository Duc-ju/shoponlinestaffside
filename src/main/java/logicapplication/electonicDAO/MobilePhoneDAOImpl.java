package logicapplication.electonicDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.electronic.MobilePhone;

public class MobilePhoneDAOImpl implements MobilePhoneDAO {

	@Override
	public List<MobilePhone> getAll() {
		List<MobilePhone> mobilePhones = new ArrayList<MobilePhone>();
      	try {
             	PreparedStatement preparedStatement = con
                          	.prepareStatement("SELECT * FROM mobilephone;");
             	System.out.println(preparedStatement);
             	ResultSet rs = preparedStatement.executeQuery();
             	while (rs.next()) {
                   	MobilePhone mobilePhone = new MobilePhone();
                   	mobilePhone.setRAM(rs.getString(1));
                   	mobilePhone.setProcessorType(rs.getString(2));
                   	mobilePhone.setStorageCapacity(rs.getString(3));
                   	mobilePhone.setMobileCableType(rs.getString(4));
                   	int mobilePhoneID = rs.getInt(5);
                   	mobilePhone.setId(mobilePhoneID);
                   	try {
                          	PreparedStatement preparedStatement1 = con
                                        	.prepareStatement("SELECT * FROM electronic WHERE ID = ?");
                          	preparedStatement1.setInt(1, mobilePhoneID);
                          	System.out.println(preparedStatement1);
                          	ResultSet rs1 = preparedStatement1.executeQuery();
                          	if (rs1.next()) {
                                 	mobilePhone.setProductName(rs1.getString(2));
                                 	mobilePhone.setBatteryCapacity(rs1.getString(3));
                                 	mobilePhone.setWarrantyDuration(rs1.getString(4));
                                 	mobilePhone.setWarrantyType(rs1.getString(5));
                                 	mobilePhone.setCondition(rs1.getString(6));
                                 	mobilePhone.setScreenSize(rs1.getString(7));
                                 	mobilePhone.setBrand(rs1.getString(8));
                          	}
                          	mobilePhones.add(mobilePhone);
                   	} catch (SQLException e) {
                          	// TODO Auto-generated catch block
                          	e.printStackTrace();
                   	}
             	}
      	} catch (SQLException e) {
             	// TODO Auto-generated catch block
             	e.printStackTrace();
      	}
      	return mobilePhones;
	}

	@Override
	public MobilePhone get(int id) {
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("SELECT * FROM mobilephone WHERE ElectronicID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				MobilePhone mobilePhone = new MobilePhone();
				mobilePhone.setRAM(rs.getString(1));
				mobilePhone.setProcessorType(rs.getString(2));
				mobilePhone.setStorageCapacity(rs.getString(3));
				mobilePhone.setMobileCableType(rs.getString(4));
				int mobilePhoneID = rs.getInt(5);
				mobilePhone.setId(mobilePhoneID);
				try {
					PreparedStatement preparedStatement1 = con
							.prepareStatement("SELECT * FROM electronic WHERE ID = ?");
					preparedStatement1.setInt(1, mobilePhoneID);
					System.out.println(preparedStatement1);
					ResultSet rs1 = preparedStatement1.executeQuery();
					if (rs1.next()) {
						mobilePhone.setProductName(rs1.getString(2));
						mobilePhone.setBatteryCapacity(rs1.getString(3));
						mobilePhone.setWarrantyDuration(rs1.getString(4));
						mobilePhone.setWarrantyType(rs1.getString(5));
						mobilePhone.setCondition(rs1.getString(6));
						mobilePhone.setScreenSize(rs1.getString(7));
						mobilePhone.setBrand(rs1.getString(8));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return mobilePhone;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int add(MobilePhone t) {
		int ElectronicID = 0;
      	try {
             	PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO `electronic`"
                          	+ "  (ProductName, BatteryCapacity, WarrantyDuration, WarrantyType, `Condition`, ScreenSize, Brand) VALUES "
                          	+ " (?, ?, ?, ?, ?, ?, ?);");

             	preparedStatement.setString(1, t.getProductName());
             	preparedStatement.setString(2, t.getBatteryCapacity());
             	preparedStatement.setString(3, t.getWarrantyDuration());
             	preparedStatement.setString(4, t.getWarrantyType());
             	preparedStatement.setString(5, t.getCondition());
             	preparedStatement.setString(6, t.getScreenSize());
             	preparedStatement.setString(7, t.getBrand());

             	System.out.println(preparedStatement);
             	preparedStatement.executeUpdate();
             	try {
                   	PreparedStatement preparedStatement1 = con.prepareStatement("SELECT MAX(ID) FROM `electronic`;");
                   	System.out.println(preparedStatement1);
                   	ResultSet rs1 = preparedStatement1.executeQuery();
                   	if (rs1.next()) {
                          	ElectronicID = rs1.getInt(1);
                          	PreparedStatement preparedStatement2 = con.prepareStatement("INSERT INTO `mobilephone`"
                                        	+ "  (RAM, ProcessorType, StorageCapacity, MobileCableType, ElectronicID) VALUES " + " (?, ?, ?, ?, ?);");

                          	preparedStatement2.setString(1, t.getRAM());
                          	preparedStatement2.setString(2, t.getProcessorType());
                          	preparedStatement2.setString(3, t.getStorageCapacity());
                          	preparedStatement2.setString(4, t.getMobileCableType());
                          	preparedStatement2.setInt(5, ElectronicID);

                          	System.out.println(preparedStatement2);
                          	preparedStatement2.executeUpdate();
                   	}
             	} catch (SQLException e) {
                   	e.printStackTrace();
             	}

      	} catch (SQLException e) {
             	// TODO Auto-generated catch block
             	e.printStackTrace();
      	}

      	return ElectronicID;
	}

	@Override
	public void update(MobilePhone t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(MobilePhone t) {
		// TODO Auto-generated method stub

	}

}
