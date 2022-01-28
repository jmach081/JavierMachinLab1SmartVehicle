package ISM6106.javiermachin.landroid.model;

public class PositionSensor extends Sensor {

	private double maxDetectionDistance;

	public PositionSensor() {
		this.maxDetectionDistance = 5;
	}

	@Override
	public void scan() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void sendSignal() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public String getComponentName() {
		return "PositionSensor";
	}

	@Override
	public boolean selfCheck() {
		System.out.println("PositionSensor check... OK");
		return true;
	}

}