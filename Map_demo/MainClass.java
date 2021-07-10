package Map_demo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MainClass {

	public static void main(String[] args) 
	{
		Map<String, List<ElectronicDevice>>  eleMap = new HashMap<>();
		ElectronicDevice c1=new Computer(111,"DELL","Grey",80000,256,true,5);
		ElectronicDevice c2=new Computer(112,"HCL","Black",45000,256,true,3);
		ElectronicDevice c3=new Computer(113,"Lenovo","Black",75000,256,true,4);
		List<ElectronicDevice> compList = new ArrayList<>();
		compList.add(c1);
		compList.add(c2);
		compList.add(c3);
		eleMap.put("Computer", compList);
		ElectronicDevice w1=new WashingMachine(222,"Panasonic","Grey",60000,12,4);
		ElectronicDevice w2=new WashingMachine(223,"LG","Grey",50000,12,3);
		ElectronicDevice w3=new WashingMachine(224,"Godrej","Grey",40000,12,5);
		List<ElectronicDevice> washList = new ArrayList<>();
		washList.add(w1);
		washList.add(w2);
		washList.add(w3);
		eleMap.put("WashingMachine", washList);
		ElectronicDevice a1=new AC(331,"LG","White",60000,10800,2);
		ElectronicDevice a2=new AC(332,"Panasonic","Black",50000,10800,2);
		ElectronicDevice a3=new AC(333,"Samsung","Grey",80000,10800,2);
		List<ElectronicDevice> acList = new ArrayList<>();
		acList.add(a1);
		acList.add(a2);
		acList.add(a3);
		eleMap.put("AC",acList);
		
		Iterator<String> itr = eleMap.keySet().iterator();
		
		while(itr.hasNext())
		{
			
			String deviceName = itr.next();
			
			
			if(deviceName.equals("WashingMachine"))
			{
				List<ElectronicDevice> eleDevices = eleMap.get(deviceName);
				
				for (ElectronicDevice device : eleDevices) {
					if(device.getPrice()>=50000 && device.getPrice()<=80000)
					{
						System.out.println(device.brandName);
					}
				}
			}
		}
		System.out.println("------------------------------");
		Collections.sort(washList,new SortBasedonRatings());
		doPrint(washList," Sort Data Based on Ratings ");
		System.out.println("------------------------------");
		Collections.sort(washList,new SortBasedonPrice());
		doPrint(washList," Sort Data Based on Price ");
	}
	public static void doPrint(Collection<ElectronicDevice> collection,String tagLine)
	{
		System.out.println("\n\n ============"+tagLine+"=========================\n");
		
		for (ElectronicDevice device : collection) {
			System.out.println(device.brandName);
		}
	}

}
