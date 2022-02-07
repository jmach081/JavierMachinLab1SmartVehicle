package ISM6106.javiermachin.landroid.model;

import edu.fiu.jit.SelfCheckCapable;
import edu.fiu.jit.SelfCheckUtils;

public class Engine implements SelfCheckCapable  {

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

	@Override
	public String getComponentName() {
		return "EV-001-" + String.valueOf(this.output);
	}

	@Override
	public boolean selfCheck() {
		boolean checkResult = SelfCheckUtils.randomCheck(0.1);

		if (checkResult)
			System.out.println("Engine " + this.getComponentName() + " check... OK");
		else
			System.out.println("Engine " + this.getComponentName() + " check... Bad");

		return checkResult;
	}
	
	@Override
	public String toString() 
	{
		return this.getComponentName();
	}

}
