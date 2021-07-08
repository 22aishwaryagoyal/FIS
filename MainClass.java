
public class MainClass {

	public static void main(String[] args) 
	{
		MainClass m=new MainClass();
		ElectronicDevice mobile=new Mobile(123,"Samsung","Black",1000,128,"Dark");
		ElectronicDevice computer=new Computer(111,"HCL","Grey",2000,256,true);
		ElectronicDevice washingmachine=new WashingMachine(222,"Panasonic","Grey",4000,12);
		ElectronicDevice ac=new AC(333,"LG","White",5000,10800);
		Camera camera=new Camera("Nikon");
		Mobile nikon=new Mobile(123, "Apple","White", 1000,128 ,"Light");
		m.displayPower(mobile);
		m.displayPower(computer);
		m.displayPower(washingmachine);
		m.displayPower(ac);
		nikon.setCamera(camera);
		System.out.println(nikon.getCamera());
	}
	public void displayPower(ElectronicDevice e)
	{
		if(e instanceof Mobile)
		{
			System.out.print("Mobile Powwer Consumption: ");
			System.out.println((int)(e.getPower()*0.5));
		}
		else if(e instanceof Computer)
		{
			System.out.print("Computer Powwer Consumption: ");
			System.out.println(e.getPower()*500);
		}
		else if(e instanceof WashingMachine)
		{
			System.out.print("Washing Machine Power Consumption: ");
			System.out.println(e.getPower()*400);
		}
		else if(e instanceof AC)
		{
			System.out.print("AC Power Consumption: ");
			System.out.println(e.getPower()*800);
		}
	}

}
