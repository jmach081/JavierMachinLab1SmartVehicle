package ISM6106.javiermachin.landroid.model;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

import edu.fiu.jit.SelfCheckCapable;

/**
 * Class to represent a Landroid
 * 
 * @author xmachin
 *
 */
public class Landroid {

	private String name;
	private String nickName; // Nick name set by the owner
	private LandroidType landroidType; // The type of the Landroid only 3 types on production
	private Battery battery;
	private SortedMap<Integer, PropulsorUnit> impulsorUnits;
	private SortedMap<Integer, SelfCheckCapable> sensorArray;

	public Landroid(String name, LandroidType landroidType) {
		this.name = name;
		this.landroidType = landroidType;
	}

	public Landroid(String name, LandroidType landroidType, Battery battery) {
		this.name = name;
		this.landroidType = landroidType;
		this.battery = battery;
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
		// TODO - Implement Method
		System.out.println("moveForward");
	}

	public void moveBackwards() {
		// TODO - Implement Method
		System.out.println("moveBackwards");
	}

	public void turnLeft() {
		// TODO - Implement Method
		System.out.println("turnLeft");
	}

	public void turnRight() {
		// TODO - Implement Method
		System.out.println("turnRight");
	}

	public void spinClockWise(Integer angle) {
		// TODO - Implement Method
		System.out.println("spinClockWise");
	}

	public void spinCounterClockWise(Integer angle) {
		// TODO - Implement Method
		System.out.println("spinCounterClockWise");
	}

	public void turnOn() {
		// TODO - Implement Method
		System.out.println("turnOn");
	}

	public void turnOff() {
		// TODO - Implement Method
		System.out.println("turnOff");
	}

	public void findClosestWire() {
		// TODO - Implement Method
		System.out.println("findClosestWire");
	}

	public void goToChargeStation() {
		// TODO - Implement Method
		System.out.println("goToChargeStation");
	}

	public void systemCheck() {
		int errorCount = 0;
		
		Set<Entry<Integer, SelfCheckCapable>> set = sensorArray.entrySet();
		Iterator<Entry<Integer, SelfCheckCapable>> i = set.iterator();
		while (i.hasNext()) {
			Entry<Integer, SelfCheckCapable> me = i.next();
			if ( !me.getValue().selfCheck() ) errorCount++;
		}
		
		// Check battery that is not a self check component
		if (this.battery == null) errorCount++;
		if (this.battery.selfCheck()) errorCount++;
		
//		TODO - if errorCount > 0 send error message to display if no error send message everything ok 
		
	}
}
