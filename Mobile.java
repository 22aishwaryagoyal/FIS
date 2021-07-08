
class Mobile extends ElectronicDevice
{
	private int memory;
	private String mode;
	public Mobile(int modelNo, String brandName, String color, int power,int memory,String mode) {
		super(modelNo, brandName, color, power);
		this.memory=memory;
		this.mode=mode;
	}
	private Camera camera;
	public Camera getCamera() {
		return camera;
	}
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	
}
