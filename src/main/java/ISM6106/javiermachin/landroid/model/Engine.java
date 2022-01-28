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
		System.out.println("Engine spinning Clockwise...");
	}

	public void SpinCounterClockWise() {
		System.out.println("Engine spinning counterClockwise...");
	}

	public void Stop() {
		System.out.println("Engine Stop...");
	}

}
