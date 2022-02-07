package ISM6106.javiermachin.landroid.model;

import ISM6106.javiermachin.landroid.model.*;
import edu.fiu.jit.SelfCheckCapable;
import edu.fiu.jit.SelfCheckTester;
import edu.fiu.jit.SelfCheckUtils;

/**
 * Composition of engine and Wheels that will spin and brake asynchronously
 * based on demand
 */
public class PropulsorUnit implements SelfCheckCapable {

	private Wheel wheel;
	private Engine engine;
	private SpinningStatus spinningStatus;

	/**
	 * 
	 * @param wheel
	 * @param engine
	 */
	public PropulsorUnit(Wheel wheel, Engine engine) {
		if (wheel == null) throw new IllegalArgumentException("invalid parameter wheel. Must be not null");
		if (engine == null) throw new IllegalArgumentException("invalid parameter engine. Must be not null");
		this.wheel = wheel;
		this.engine = engine;
		this.spinningStatus = SpinningStatus.Stop;
	}

	public void Stop() {
		this.spinningStatus = SpinningStatus.Stop;
		this.engine.Stop();
	}

	public void SpinClockWise() {
		Stop();
		this.spinningStatus = SpinningStatus.SpinningClockWise;
		this.engine.SpinClockWise();
	}

	public void SpinCounterClockWise() {
		Stop();
		this.spinningStatus = SpinningStatus.SpinningCounterClockWise;
		this.engine.SpinCounterClockWise();
	}

	/**
	 * Gets the current status of the propulsor unit
	 * 
	 * @return
	 */
	public SpinningStatus getSpinningStatus() {
		return spinningStatus;
	}

	@Override
	public String getComponentName() {
		return "Propulsor E" + this.engine.getComponentName() + "-W" + String.valueOf(this.wheel.getSize());
	}

	@Override
	public boolean selfCheck() {
		boolean checkResult = SelfCheckUtils.randomCheck(0.1) && this.engine.selfCheck();

		if (checkResult)
			System.out.println("PropulsorUnit " + this.getComponentName() + " check... OK");
		else
			System.out.println("PropulsorUnit " + this.getComponentName() + " check... Bad");

		return checkResult;
	}
	
	@Override
	public String toString() {
		return this.getComponentName();
	}
}