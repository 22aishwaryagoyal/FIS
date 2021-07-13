package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import model.ElectronicDevice;
import exce.NoDeviceFoundException;

public class ElectronicsDAOImpl implements IElectronicDeviceDAO
{
	Connection con = null;

	String insertDevice = "insert into Electronics.electronics values(?,?,?,?,?,?,?)";
	String selectAllDevices = "select * from Electronics.electronics";
	String updateCost="update Electronics.electronics set cost=? where deviceId=? ";
	String updateRating="update Electronics.electronics set starRatings=? where deviceId=?";
	String deleteEntry="delete from Electronics.electronics where deviceId=?";
	String displayBasedType="select * from Electronics.electronics group by brandName,deviceType";
	String countType="select deviceType,count(deviceType)as Count from Electronics.electronics group by deviceType";
	String sumPrice="select deviceType,sum(cost)as Sum from Electronics.electronics group by deviceType";
	@Override
	public boolean addDevice(ElectronicDevice device) throws Exception
	{
		con = DatabaseUtil.getConnection();
		boolean isInserted = false;
		if (con != null) {

			
			int id = device.getDeviceId();
			String name = device.getDeviceType();
			String brand=device.getBrandName();
			int cost=device.getCost();
			int power=device.getPower();
			int rating=device.getStarRatings();
			String color=device.getColor();

			PreparedStatement ps = con.prepareStatement(insertDevice);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, brand);
			ps.setInt(4, cost);
			ps.setInt(5, power);
			ps.setInt(6, rating);
			ps.setString(7, color);
			// Step 3 : execute Query
			int i = ps.executeUpdate(); // only works with insert , update & delete

			if (i > 0)
				isInserted = true;

		}

		return isInserted;
	}

	@Override
	public List<ElectronicDevice> getAllDevices() throws Exception{
		
		con = DatabaseUtil.getConnection();
		List<ElectronicDevice> electronicsList = new ArrayList<>();
		if (con != null) {

			PreparedStatement ps = con.prepareStatement(selectAllDevices);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ElectronicDevice temp = new ElectronicDevice(); // default emp,

				temp.setDeviceId(rs.getInt(1));
				temp.setDeviceType(rs.getString(2));
				temp.setBrandName(rs.getString(3));
				temp.setCost(rs.getInt(4));
				temp.setPower(rs.getInt(5));
				temp.setStarRatings(rs.getInt(6));
				temp.setColor(rs.getString(7));
				electronicsList.add(temp);
			}

		}
		return electronicsList;
	}

	@Override
	public boolean changeDevicePrice(int deviceId, int newPrice)
			throws NoDeviceFoundException, SQLException 
		{
		//String updateCost="update Electronics.electronics set cost=? where deviceId=? ";
		con = DatabaseUtil.getConnection();
		boolean isUpdated = false;
		if (con != null) {

			PreparedStatement ps = con.prepareStatement(updateCost);
			ps.setInt(1,newPrice);
			ps.setInt(2,deviceId);
			int i = ps.executeUpdate();
			// only works with insert , update & delete
			System.out.println("i="+i);
			if (i > 0)
				isUpdated = true;
		}
		
		return isUpdated;
		}
	@Override
	public boolean changeDeviceRating(int deviceId, int newRating)
			throws NoDeviceFoundException, SQLException
	{
		con = DatabaseUtil.getConnection();
		boolean isUpdated = false;
		if (con != null) {

			PreparedStatement ps = con.prepareStatement(updateRating);
			ps.setInt(1,newRating);
			ps.setInt(2,deviceId);
			int i = ps.executeUpdate();
			// only works with insert , update & delete
			System.out.println("i="+i);
			if (i > 0)
				isUpdated = true;
		}
		
		return isUpdated;
		
	}

	@Override
	public boolean deleteDevice(int deviceId) throws NoDeviceFoundException, SQLException {
		
		con = DatabaseUtil.getConnection();
		boolean isUpdated = false;
		if (con != null) {

			PreparedStatement ps = con.prepareStatement(deleteEntry);
			ps.setInt(1,deviceId);
			
			int i = ps.executeUpdate();
			// only works with insert , update & delete
			System.out.println("i="+i);
			if (i > 0)
				isUpdated = true;
		}
		
		return isUpdated;
	}

	@Override
	public List<ElectronicDevice> geDevicesBasedOnBrandNameAndType(
			String brandName, String type) throws SQLException
			{
				
		con = DatabaseUtil.getConnection();
		List<ElectronicDevice> electronicsList = new ArrayList<>();
		if (con != null) {

			PreparedStatement ps = con.prepareStatement(displayBasedType);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ElectronicDevice temp = new ElectronicDevice(); 

				temp.setDeviceId(rs.getInt(1));
				temp.setDeviceType(rs.getString(2));
				temp.setBrandName(rs.getString(3));
				temp.setCost(rs.getInt(4));
				temp.setPower(rs.getInt(5));
				temp.setStarRatings(rs.getInt(6));
				temp.setColor(rs.getString(7));
				electronicsList.add(temp);
			}

		}
		return electronicsList;
			}

	@Override
	public int countDeviceType(String type) throws SQLException 
	{
		//String countType="select deviceType,count(deviceType)as Count from Electronics.electronics group by deviceType";
		con = DatabaseUtil.getConnection();
		int count=0;
		if (con != null) {

			PreparedStatement ps = con.prepareStatement(countType);
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				count=rs.getInt("Count");
				String dtype=rs.getString("deviceType");
				System.out.println(dtype+"-"+count);
			}
		
		}
		return count;
	}

	@Override
	public int getSumofPriceBasedOnType(String type) throws SQLException
	{
		con = DatabaseUtil.getConnection();
		int total=0;
		if (con != null) {

			PreparedStatement ps = con.prepareStatement(sumPrice);
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				total=rs.getInt("Sum");
				String dtype=rs.getString("deviceType");
				System.out.println(dtype+"-"+total);
			}
		
		}
		return total;
	}

	@Override
	public List<ElectronicDevice> geDevicesBasedOnPriceRangeandType(int range1,
			int range2, String type, List<ElectronicDevice> ls)
			throws SQLException {
		ls=ls.stream().filter(ed1->{return ed1.getDeviceType().equals(type)&& ed1.getCost()>=range1&&((ElectronicDevice)ed1).getCost()<=range2;}).collect(Collectors.toList());
		return ls;
	}
	
	
}
