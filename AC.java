
public class AC extends ElectronicDevice
{
	private int weight;
	public AC(int modelNo, String brandName, String color, int power,int weight) {
		super(modelNo, brandName, color, power);
		this.weight=weight;
	}
}
