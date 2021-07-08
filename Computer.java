
public class Computer extends ElectronicDevice
{
	private int RamSize;
	private boolean bluetooth;
	
	public Computer(int modelNo, String brandName, String color, int power,int RamSize,boolean bluetooth)
	{
		super(modelNo, brandName, color, power);
		this.RamSize=RamSize;
		this.bluetooth=bluetooth;
	}
	
	
}
