package Map_demo;

public class WashingMachine extends ElectronicDevice
{
	private int rpm;
	private int ratings;
	public WashingMachine(int modelNo, String brandName, String color, int price,int rpm,int ratings) {
		super(modelNo, brandName, color, price,ratings);
		this.rpm=rpm;
	}

}
