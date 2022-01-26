package ISM6106.javiermachin.landroid.model;

import ISM6106.javiermachin.landroid.model.*;


/**
 * Composition of engine and Wheels that will spin and brake asynchronously based on demand
 */
public class PropulsorUnit {

    private Wheel wheel;
    private Engine engine;

    /**
	 * 
	 * @param wheel
	 * @param engine
	 */
	public PropulsorUnit(Wheel wheel, Engine engine)    {
        this.wheel = wheel;
        this.engine = engine;
    }

    public void Stop(){
        this.engine.Stop();
    }

    public void SpinClockWise() {
        this.engine.SpinClockWise();
    }

    public void SpinCounterClockWise() {
        this.engine.SpinCounterClockWise();
    }
}