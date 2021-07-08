
public class WashingMachine extends ElectronicDevice
{
	private int rpm;
	public WashingMachine(int modelNo, String brandName, String color, int power,int rpm) {
		super(modelNo, brandName, color, power);
		this.rpm=rpm;
	}

}
