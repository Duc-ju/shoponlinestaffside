package logicapplication.electonicDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicapplication.bookDAO.BookItemDAOImpl;
import model.book.BookItem;
import model.electronic.Electronic;
import model.electronic.ElectronicItem;

public class ElectronicItemDAOImpl implements ElectronicItemDAO{

	@Override
	public List<ElectronicItem> getAll() {
		List<ElectronicItem> electronicItems = new ArrayList<>();
      	try {
             	PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM electronicitem");
             	System.out.println(preparedStatement);
             	ResultSet rs = preparedStatement.executeQuery();
             	while (rs.next()) {
                   	ElectronicItem electronicItem = new ElectronicItem();
                   	int id = rs.getInt(1);
                   	electronicItem.setId(id);                  	
                   	int electronicID = rs.getInt(2);
                   	
                   	if(new TabletDAOPImpl().get(electronicID) != null) {
                          	electronicItem.setElectronic(new TabletDAOPImpl().get(electronicID));
                   	}else if(new LaptopDAOIml().get(electronicID) != null) {
                          	electronicItem.setElectronic(new LaptopDAOIml().get(electronicID));
                   	} else {
                          	electronicItem.setElectronic(new MobilePhoneDAOImpl().get(electronicID));
                   	}
                   	
                   	electronicItem.setPrices(rs.getFloat(3));
                   	electronicItem.setDescription(rs.getString(4));
                   	electronicItem.setHeader(rs.getString(5));
                   	electronicItem.setDiscount(rs.getFloat(6));


                   	List<String> image = new ArrayList<>();
                   	try {
                          	PreparedStatement preparedStatement1 = con
                                        	.prepareStatement("SELECT * FROM electronicitem_image WHERE ElectronicItemID = ?");
                          	System.out.println(preparedStatement1);
                          	preparedStatement1.setInt(1, id);
                          	ResultSet rs1 = preparedStatement1.executeQuery();

                          	while (rs1.next()) {
                                 	String imageString = rs1.getString(3);
                                 	image.add(imageString);
                          	}
                   	} catch (SQLException e) {
                          	// TODO Auto-generated catch block
                          	e.printStackTrace();
                   	}

                   	electronicItem.setImage(image);

                   	electronicItems.add(electronicItem);
             	}
      	} catch (SQLException e) {
             	// TODO Auto-generated catch block
             	e.printStackTrace();
      	}
      	return electronicItems;
	}

	@Override
	public ElectronicItem get(int id) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM electronicitem WHERE ID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				ElectronicItem electronicItem = new ElectronicItem();

				electronicItem.setId(rs.getInt(1));
				int electronicID = rs.getInt(2);

				if (new TabletDAOPImpl().get(electronicID) != null) {
					electronicItem.setElectronic(new TabletDAOPImpl().get(electronicID));
				} else if (new LaptopDAOIml().get(electronicID) != null) {
					electronicItem.setElectronic(new LaptopDAOIml().get(electronicID));
				} else {
					electronicItem.setElectronic(new MobilePhoneDAOImpl().get(electronicID));
				}

				electronicItem.setPrices(rs.getFloat(3));
				electronicItem.setDescription(rs.getString(4));
				electronicItem.setHeader(rs.getString(5));
				electronicItem.setDiscount(rs.getFloat(6));

				List<String> image = new ArrayList<>();
				try {
					PreparedStatement preparedStatement1 = con
							.prepareStatement("SELECT * FROM electronicitem_image WHERE ElectronicItemID = ?");
					System.out.println(preparedStatement1);
					preparedStatement1.setInt(1, id);

					ResultSet rs1 = preparedStatement1.executeQuery();

					while (rs1.next()) {
						String imageString = rs1.getString(3);
						image.add(imageString);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				electronicItem.setImage(image);

				return electronicItem;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int add(ElectronicItem t) {
		// TODO Auto-generated method stub
		String insertString = "insert into electronicitem(ElectronicID, Prices, Description, Header, Discount)"
				+ "values(?,?,?,?,?)";
		String insertImage = "insert into electronicitem_image(ElectronicItemID, ElectronicItemIndex, Image)"
				+ "values(?,?,?)";
		try {
         	PreparedStatement ps = con.prepareStatement(insertString, Statement.RETURN_GENERATED_KEYS);
         	ps.setInt(1, t.getElectronic().getId());
         	ps.setFloat(2,  t.getPrices());
         	ps.setString(3, t.getDescription());
         	ps.setString(4, t.getHeader());
         	ps.setFloat(5, t.getDiscount());
         	ps.executeUpdate();
         	ResultSet rs = ps.getGeneratedKeys();
         	while (rs.next()) {
               	t.setId(rs.getInt(1));
         	}
         	ps =  con.prepareStatement(insertImage);
         	ps.setInt(1, t.getId());
         	for(int i = 0; i < t.getImage().size(); i++) {
         		ps.setInt(2, i+1);
         		ps.setString(3, t.getImage().get(i));
         		ps.executeUpdate();
         	}
  	} catch (SQLException e) {
         	// TODO Auto-generated catch block
         	e.printStackTrace();
  	}
		return t.getId();
	}

	@Override
	public void update(ElectronicItem t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ElectronicItem t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ElectronicItem> getListByHeader(String header) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		ElectronicItem electronicItem = new ElectronicItemDAOImpl().get(1);
		System.out.println(electronicItem.getElectronic().getProductName());
	}

	@Override
	public List<ElectronicItem> getLaptopItems() {
		List<ElectronicItem> electronicItems = new ArrayList<>();
      	try {
             	PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM `electronicitem` WHERE ID IN (\r\n"
             			+ "	SELECT ElectronicID FROM laptop\r\n"
             			+ ")");
             	System.out.println(preparedStatement);
             	ResultSet rs = preparedStatement.executeQuery();
             	while (rs.next()) {
                   	ElectronicItem electronicItem = new ElectronicItem();
                   	int id = rs.getInt(1);
                   	electronicItem.setId(id);                  	
                   	int electronicID = rs.getInt(2);
                    electronicItem.setElectronic(new LaptopDAOIml().get(electronicID));
                   	electronicItem.setPrices(rs.getFloat(3));
                   	electronicItem.setDescription(rs.getString(4));
                   	electronicItem.setHeader(rs.getString(5));
                   	electronicItem.setDiscount(rs.getFloat(6));


                   	List<String> image = new ArrayList<>();
                   	try {
                          	PreparedStatement preparedStatement1 = con
                                        	.prepareStatement("SELECT * FROM electronicitem_image WHERE ElectronicItemID = ?");
                          	System.out.println(preparedStatement1);
                          	preparedStatement1.setInt(1, id);
                          	ResultSet rs1 = preparedStatement1.executeQuery();

                          	while (rs1.next()) {
                                 	String imageString = rs1.getString(3);
                                 	image.add(imageString);
                          	}
                   	} catch (SQLException e) {
                          	// TODO Auto-generated catch block
                          	e.printStackTrace();
                   	}

                   	electronicItem.setImage(image);

                   	electronicItems.add(electronicItem);
             	}
      	} catch (SQLException e) {
             	// TODO Auto-generated catch block
             	e.printStackTrace();
      	}
      	return electronicItems;
	}

	@Override
	public List<ElectronicItem> getTabletItems() {
		List<ElectronicItem> electronicItems = new ArrayList<>();
      	try {
             	PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM `electronicitem` WHERE ID IN (\r\n"
             			+ "	SELECT ElectronicID FROM tablet\r\n"
             			+ ")");
             	System.out.println(preparedStatement);
             	ResultSet rs = preparedStatement.executeQuery();
             	while (rs.next()) {
                   	ElectronicItem electronicItem = new ElectronicItem();
                   	int id = rs.getInt(1);
                   	electronicItem.setId(id);                  	
                   	int electronicID = rs.getInt(2);
                    electronicItem.setElectronic(new TabletDAOPImpl().get(electronicID));
                   	electronicItem.setPrices(rs.getFloat(3));
                   	electronicItem.setDescription(rs.getString(4));
                   	electronicItem.setHeader(rs.getString(5));
                   	electronicItem.setDiscount(rs.getFloat(6));


                   	List<String> image = new ArrayList<>();
                   	try {
                          	PreparedStatement preparedStatement1 = con
                                        	.prepareStatement("SELECT * FROM electronicitem_image WHERE ElectronicItemID = ?");
                          	System.out.println(preparedStatement1);
                          	preparedStatement1.setInt(1, id);
                          	ResultSet rs1 = preparedStatement1.executeQuery();

                          	while (rs1.next()) {
                                 	String imageString = rs1.getString(3);
                                 	image.add(imageString);
                          	}
                   	} catch (SQLException e) {
                          	// TODO Auto-generated catch block
                          	e.printStackTrace();
                   	}

                   	electronicItem.setImage(image);

                   	electronicItems.add(electronicItem);
             	}
      	} catch (SQLException e) {
             	// TODO Auto-generated catch block
             	e.printStackTrace();
      	}
      	return electronicItems;
	}

	@Override
	public List<ElectronicItem> getMobilePhones() {
		List<ElectronicItem> electronicItems = new ArrayList<>();
      	try {
             	PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM `electronicitem` WHERE ID IN (\r\n"
             			+ "	SELECT ElectronicID FROM mobilephone\r\n"
             			+ ")");
             	System.out.println(preparedStatement);
             	ResultSet rs = preparedStatement.executeQuery();
             	while (rs.next()) {
                   	ElectronicItem electronicItem = new ElectronicItem();
                   	int id = rs.getInt(1);
                   	electronicItem.setId(id);                  	
                   	int electronicID = rs.getInt(2);
                    electronicItem.setElectronic(new MobilePhoneDAOImpl().get(electronicID));
                   	electronicItem.setPrices(rs.getFloat(3));
                   	electronicItem.setDescription(rs.getString(4));
                   	electronicItem.setHeader(rs.getString(5));
                   	electronicItem.setDiscount(rs.getFloat(6));


                   	List<String> image = new ArrayList<>();
                   	try {
                          	PreparedStatement preparedStatement1 = con
                                        	.prepareStatement("SELECT * FROM electronicitem_image WHERE ElectronicItemID = ?");
                          	System.out.println(preparedStatement1);
                          	preparedStatement1.setInt(1, id);
                          	ResultSet rs1 = preparedStatement1.executeQuery();

                          	while (rs1.next()) {
                                 	String imageString = rs1.getString(3);
                                 	image.add(imageString);
                          	}
                   	} catch (SQLException e) {
                          	// TODO Auto-generated catch block
                          	e.printStackTrace();
                   	}

                   	electronicItem.setImage(image);

                   	electronicItems.add(electronicItem);
             	}
      	} catch (SQLException e) {
             	// TODO Auto-generated catch block
             	e.printStackTrace();
      	}
      	return electronicItems;
	}
}
