package ISM6106.javiermachin.landroid.model;

import edu.fiu.jit.SelfCheckCapable;

public abstract class Sensor implements SelfCheckCapable {

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