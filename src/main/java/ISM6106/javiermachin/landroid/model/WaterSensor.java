package ISM6106.javiermachin.landroid.model;

public class WaterSensor extends Sensor {

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
		return "WaterSensor";
	}

	@Override
	public boolean selfCheck() {
		System.out.println("WaterSensor check... OK");
		return true;
	}
}