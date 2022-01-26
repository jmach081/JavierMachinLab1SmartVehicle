package ISM6106.javiermachin.landroid.model;

public class Engine {

	/**
	 * The motor output in kilowatts
	 */
	private double output;

	public Engine(double output) {
		this.output = output;
	}
	
	/**
	 * Gets the horse power of the engine
	 * @return
	 */
	public double getHorsePower() {
		return this.output * 3.14;
	}

	public void SpinClockWise() {
		// TODO - implement Engine.SpinClockWise
		throw new UnsupportedOperationException();
	}

	public void SpinCounterClockWise() {
		// TODO - implement Engine.SpinCounterClockWise
		throw new UnsupportedOperationException();
	}

	public void Stop() {
		// TODO - implement Engine.Stop
		throw new UnsupportedOperationException();
	}

}
