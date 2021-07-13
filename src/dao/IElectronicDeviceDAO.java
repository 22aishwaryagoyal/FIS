package dao;
import java.sql.SQLException;
import java.util.List;

import exce.NoDeviceFoundException;
import model.ElectronicDevice;

public interface IElectronicDeviceDAO {

	
	public boolean addDevice(ElectronicDevice device) throws Exception;
	public List<ElectronicDevice> getAllDevices() throws Exception;
	
	public boolean changeDevicePrice(int deviceId,int newPrice)throws NoDeviceFoundException, SQLException;
	public boolean changeDeviceRating(int deviceId,int newRating)throws NoDeviceFoundException, SQLException;
	
	public boolean deleteDevice(int deviceId)throws NoDeviceFoundException, SQLException;
	
	public List<ElectronicDevice> geDevicesBasedOnBrandNameAndType(String brandName,String type) throws SQLException;
	public int countDeviceType(String type) throws SQLException;
	public int getSumofPriceBasedOnType(String type) throws SQLException;
	public List<ElectronicDevice> geDevicesBasedOnPriceRangeandType(int range1,int range2,String type,List<ElectronicDevice>ls) throws SQLException;
	
	
	
}