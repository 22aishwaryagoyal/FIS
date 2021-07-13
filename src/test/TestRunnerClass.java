package test;

import java.util.List;

import model.ElectronicDevice;
import dao.ElectronicsDAOImpl;
import dao.IElectronicDeviceDAO;

public class TestRunnerClass 
{
public static void main(String[] args) {
		
		try {
			
			
			/* FOR Inserting Devices
			 * */
			IElectronicDeviceDAO dao = new ElectronicsDAOImpl();
			
			/*ElectronicDevice ed = new ElectronicDevice("Mobile",106,"HCL",500000,100,5,"Black");
			
			boolean a = dao.addDevice(ed);
			System.out.println(a);*/
			/*IElectronicDeviceDAO dao = new ElectronicsDAOImpl();
			List<ElectronicDevice> list = dao.getAllDevices();
			
			list.stream().forEach((emp)->System.out.println(emp));*/
			//IElectronicDeviceDAO dao = new ElectronicsDAOImpl();
			/*boolean a = dao.changeDevicePrice(101,40000);
			System.out.println(a);
			String updateCost="update Electronics.electronics set cost=? where deviceId=? ";
			
			boolean a1 = dao.changeDeviceRating(101, 3);
			System.out.println(a1);*/
			/*boolean a2=dao.deleteDevice(105);
			System.out.println(a2);*/
			/*List<ElectronicDevice> list = dao.geDevicesBasedOnBrandNameAndType("Samsung","Laptop");
			
			list.stream().forEach((emp)->System.out.println(emp));*/
			/*int a4=dao.countDeviceType("Mobile");
			System.out.println(a4);*/
			/*int a5=dao.getSumofPriceBasedOnType("Mobile");
			System.out.println(a5);*/
			List<ElectronicDevice>list=dao.getAllDevices();
			List<ElectronicDevice>filterList=dao.geDevicesBasedOnPriceRangeandType(20000,40000, "Mobile", list);
			for(ElectronicDevice filtered:filterList)
			{
				System.out.println(filtered);
			}
			
		} catch (Exception e) {
			System.out.println(" Problem "+e);
		}
	}
}
