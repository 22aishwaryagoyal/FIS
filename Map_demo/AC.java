package Map_demo;

public class AC extends ElectronicDevice
{
	private int weight;
	public AC(int modelNo, String brandName, String color, int price,int weight,int ratings) {
		super(modelNo, brandName, color, price,ratings);
		this.weight=weight;
	}
}
