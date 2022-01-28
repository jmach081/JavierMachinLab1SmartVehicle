package ISM6106.javiermachin.landroid.model;

public class WireSensor  extends Sensor {

	private double maxDetectionDistance;
	
	public WireSensor() 
	{
		this.maxDetectionDistance = 10;
	}
	
	@Override
	public String getComponentName() {
		return "WireSensor";
	}

	@Override
	public boolean selfCheck() {
		System.out.println("WireSensor check... OK");
		return true;
	}

	@Override
	public void scan() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendSignal() {
		// TODO Auto-generated method stub
	}

}
