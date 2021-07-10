package Map_demo;

public class Computer extends ElectronicDevice
{
	private int RamSize;
	private boolean bluetooth;
	
	public Computer(int modelNo, String brandName, String color, int price,int RamSize,boolean bluetooth,int ratings)
	{
		super(modelNo, brandName, color, price,ratings);
		this.RamSize=RamSize;
		this.bluetooth=bluetooth;
	}
	
	
}
