
public class ElectronicDevice
{
	int ModelNo;
	String brandName;
	String color;
	int power;
	
	public ElectronicDevice(int modelNo, String brandName, String color,int power) 
	{
		ModelNo = modelNo;
		this.brandName = brandName;
		this.color = color;
		this.power = power;
	}
	public int getModelNo() {
		return ModelNo;
	}
	public void setModelNo(int modelNo) {
		ModelNo = modelNo;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
}
