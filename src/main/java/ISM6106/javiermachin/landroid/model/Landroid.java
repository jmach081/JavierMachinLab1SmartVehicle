package ISM6106.javiermachin.landroid.model;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

import edu.fiu.jit.GenericComponent;
import edu.fiu.jit.SelfCheckCapable;
import edu.fiu.jit.SelfCheckUtils;

/**
 * Class to represent a Landroid
 * 
 * @author xmachin
 *
 */
public class Landroid implements GenericComponent {

	private String name;
	private String nickName; // Nick name set by the owner
	private LandroidType landroidType; // The type of the Landroid only 3 types on production
	private Battery battery;
	private SortedMap<Integer, PropulsorUnit> impulsorUnits;
	private SortedMap<Integer, SelfCheckCapable> sensorArray;
	private Processor processor;
	private WifiModule wifiModule;

	/**
	 * Full Constructor
	 * 
	 * @param name
	 * @param landroidType
	 * @param battery
	 * @param impulsorUnits
	 * @param sensorArray
	 */
	public Landroid(String name, LandroidType landroidType, Battery battery,
			SortedMap<Integer, PropulsorUnit> impulsorUnits, SortedMap<Integer, SelfCheckCapable> sensorArray) {
		this.name = name;
		this.landroidType = landroidType;
		this.battery = battery;
		this.impulsorUnits = impulsorUnits;
		this.sensorArray = sensorArray;
		this.processor = new Processor();
		this.wifiModule = new WifiModule();
	}

	/**
	 * Minimum Base constructor other parts need to be added later. It will fail to
	 * start if no parts added later
	 * 
	 * @param name
	 * @param landroidType
	 */
	public Landroid(String name, LandroidType landroidType) {
		this(name, landroidType, null, null, null);
	}

	/**
	 * Minimum Base constructor other parts need to be added later. It will fail to
	 * start if no parts added later
	 * 
	 * @param name
	 * @param landroidType
	 * @param battery
	 */
	public Landroid(String name, LandroidType landroidType, Battery battery) {
		this(name, landroidType, battery, null, null);
	}

	/**
	 * Gets the type of the Landroid
	 * 
	 * @return
	 */
	public LandroidType getLandroidType() {
		return landroidType;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public SortedMap<Integer, PropulsorUnit> getImpulsorUnits() {
		return impulsorUnits;
	}

	public void setImpulsorUnits(SortedMap<Integer, PropulsorUnit> impulsorUnits) {
		this.impulsorUnits = impulsorUnits;
	}

	public SortedMap<Integer, SelfCheckCapable> getSensorArray() {
		return sensorArray;
	}

	public void setSensorArray(SortedMap<Integer, SelfCheckCapable> sensorArray) {
		this.sensorArray = sensorArray;
	}

	public void moveForward() {
		System.out.println("moveForward");
		// check clearence from Position Sensor
		((PositionSensor) this.sensorArray.get(2)).scan();

		// Move both wheels forward
		this.impulsorUnits.get(1).SpinClockWise();
		this.impulsorUnits.get(2).SpinClockWise();
	}

	public void moveBackwards() {
		System.out.println("moveBackwards");
		// check clearence from Position Sensor
		((PositionSensor) this.sensorArray.get(2)).scan();

		// Move both wheels forward
		this.impulsorUnits.get(1).SpinCounterClockWise();
		this.impulsorUnits.get(2).SpinCounterClockWise();
	}

	public void turnLeft() {
		System.out.println("turnLeft");
		spinCounterClockWise(90);
	}

	public void turnRight() {
		System.out.println("turnRight");
		spinClockWise(90);
	}

	public void spinClockWise(Integer angle) {
		System.out.println("spinClockWise " + String.valueOf(angle) + " degrees");
		this.impulsorUnits.get(1).SpinCounterClockWise();
		this.impulsorUnits.get(2).SpinClockWise();
	}

	public void spinCounterClockWise(Integer angle) {
		System.out.println("spinCounterClockWise " + String.valueOf(angle) + " degrees");
		this.impulsorUnits.get(1).SpinClockWise();
		this.impulsorUnits.get(2).SpinCounterClockWise();

	}

	public void turnOn() {
		System.out.println("turnOn");
		((ControlPanel) this.sensorArray.get(1)).getPushButton().pressButton();
		systemCheck();
	}

	public void turnOff() {
		System.out.println("turnOff");
		((ControlPanel) this.sensorArray.get(1)).getPushButton().pressButton();
	}

	public void findClosestWire() {
		// TODO - Implement Method
		System.out.println("findClosestWire");
	}

	public void goToChargeStation() {
		// TODO - Implement Method
		System.out.println("goToChargeStation");
	}

	/**
	 * Performs a system check to make sure the system is fully functional Will
	 * Check for all the parts to be ready
	 */
	public boolean systemCheck() {

		System.out.println("Landroid System check....");

		int errorCount = 0;

		if (this.sensorArray == null) {
			errorCount++;
			System.out.println("Landroid System check. Critial failure. No sensors detected");
		} else {
			Set<Entry<Integer, SelfCheckCapable>> set = sensorArray.entrySet();
			Iterator<Entry<Integer, SelfCheckCapable>> i = set.iterator();
			while (i.hasNext()) {
				Entry<Integer, SelfCheckCapable> me = i.next();
				if (!me.getValue().selfCheck())
					errorCount++;
			}
		}

		// Check battery that is not a self check component
		if (this.battery == null) {
			errorCount++;
			System.out.println("Landroid System check. No battery detected");
		}

		if (!this.battery.selfCheck())
			errorCount++;

		if (this.impulsorUnits == null) {
			errorCount++;
			System.out.println("Landroid System check. No impulsor unit detected");
		}

		if (this.impulsorUnits.size() != 2) {
			errorCount++;
			System.out.println("Landroid System check. Missing one or more impulsor units");
		}

		for (PropulsorUnit propulsor : this.impulsorUnits.values()) {
			if (!propulsor.selfCheck())
				errorCount++;
		}

		System.out.println("Landroid System check Found ( " + errorCount + " ) errors.");

		if (errorCount > 0) {
			((ControlPanel) this.sensorArray.get(1)).getDisplay().displayErrorMessage("Unable to start. Review Errors");
			return false;
		}

		return true;
	}

	public void stop() {
		this.impulsorUnits.get(1).Stop();
		this.impulsorUnits.get(2).Stop();
	}

	public void inputCommand(String[] command) {
		((ControlPanel) this.sensorArray.get(1)).getKeyPad().pressKeys(command);
	}

	@Override
	public String getComponentName() {
		return "Landroid " + this.landroidType;
	}

	/***
	 * Returns True based on own internal checks multiplied by 10% of failure
	 */
	@Override
	public boolean selfCheck() {

		if (SelfCheckUtils.randomCheck(0.1) && this.systemCheck())
			return true;

		System.out.print("Major Random failure Ocurred!!!!");
		return false;
	}

	/***
	 * Gets a list of internal components that are self capable
	 */
	@Override
	public ArrayList<SelfCheckCapable> getSubComponents() {

		ArrayList<SelfCheckCapable> internalComponents = new ArrayList<SelfCheckCapable>();

		Set<Entry<Integer, SelfCheckCapable>> set = sensorArray.entrySet();
		Iterator<Entry<Integer, SelfCheckCapable>> i = set.iterator();
		while (i.hasNext()) {
			Entry<Integer, SelfCheckCapable> me = i.next();
			internalComponents.add(me.getValue());
		}

		// Add all stand alone self check components
		internalComponents.add(this.battery);
		internalComponents.add(this.impulsorUnits.get(1));
		internalComponents.add(this.impulsorUnits.get(2));

		return internalComponents;
	}

	@Override
	public String toString() {

		ArrayList<SelfCheckCapable> mysubcomponents = this.getSubComponents();

		String text = this.name + "\n";
		text += "Internal parts [" + String.valueOf(mysubcomponents.size()) + "]" + "\n";

		for (int i = 0; i < mysubcomponents.size(); i++) {
			if (i >= 0)
				text += "[" + String.valueOf(i + 1) + "] ";
			text += mysubcomponents.get(i).getComponentName() + "\n";
		}

		return text;
	}

	public Processor getProcessor() {
		return processor;
	}

	public WifiModule getWifiModule() {
		return wifiModule;
	}
}
