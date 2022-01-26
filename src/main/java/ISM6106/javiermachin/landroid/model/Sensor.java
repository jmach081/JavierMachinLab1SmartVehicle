package ISM6106.javiermachin.landroid.model;

public abstract class Sensor {

	private String sensorType;
	protected double maxAngleOfView;

	/**
	 * Sensor operation to scan environment
	 */
	public abstract void scan();

	/**
	 * Sends a signal with information about the detection
	 */
	public abstract void sendSignal();

}