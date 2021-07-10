package Map_demo;

public class ElectronicDevice
{
	int ModelNo;
	String brandName;
	String color;
	int price;
	int ratings;
	
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public ElectronicDevice(int modelNo, String brandName, String color,int price,int ratings) 
	{
		ModelNo = modelNo;
		this.brandName = brandName;
		this.color = color;
		this.price = price;
		this.ratings=ratings;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
