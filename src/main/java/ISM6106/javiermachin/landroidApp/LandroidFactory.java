package ISM6106.javiermachin.landroidApp;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import ISM6106.javiermachin.landroid.model.*;
import edu.fiu.jit.SelfCheckCapable;

public class LandroidFactory {

	public static Landroid getALandroid(LandroidType landroidType)
	{

		//Get a set of sensors for the android
		SortedMap<Integer, SelfCheckCapable> sensors = getASensorSet();
		SortedMap<Integer, PropulsorUnit> propulsionUnits = getAPropulsorUnitSet();
		
		switch (landroidType) {
		case OneFourthAcre:
			Landroid medLandroid = new Landroid("OneFourthAcre Landroid", LandroidType.OneFourthAcre, new Battery());
			medLandroid.setSensorArray(sensors);
			medLandroid.setImpulsorUnits(propulsionUnits);
			return medLandroid;
		case HalfAcre:
			Landroid bigLandroid = new Landroid("HalfAcre Landroid", LandroidType.HalfAcre, new Battery());
			bigLandroid.setSensorArray(sensors);
			bigLandroid.setImpulsorUnits(propulsionUnits);
			return bigLandroid;
		case OneEightAcre:
		default:
			var littleLandroid = new Landroid("OneEightAcre Landroid", LandroidType.OneEightAcre, new Battery(BateryType.NiMH,500,500));
			littleLandroid.setSensorArray(sensors);
			littleLandroid.setImpulsorUnits(propulsionUnits);
			return littleLandroid;
		}
	}
	
	/**
	 * Get a control panel assembled
	 * @return
	 */
	private static ControlPanel getControlPanel() {
		/* Building a control panel*/
		KeyPad aKeyPad = new KeyPad();
		Display aDisplay = new Display();
		RotarySelector aRotarySelector = new RotarySelector();
		PushButton aPushButton = new PushButton();
		ControlPanel controlPanel = new ControlPanel(aKeyPad, aDisplay, aRotarySelector,aPushButton);
		return controlPanel;
	}
	
	/**
	 * Gets a set of sensor ready
	 * @return
	 */
	private static SortedMap<Integer, SelfCheckCapable> getASensorSet(){
		SortedMap<Integer, SelfCheckCapable> sensors = new TreeMap<Integer, SelfCheckCapable>();
		
		//Build the sensor parts
		ControlPanel aControlPanel = getControlPanel();
		sensors.put(1, aControlPanel); //Assign fixed spots to each component

		PositionSensor aPositionSensor = new PositionSensor();
		sensors.put(2, aPositionSensor); //Assign fixed spots to each component
		
		WaterSensor aWaterSensor = new WaterSensor();
		sensors.put(3, aWaterSensor); //Assign fixed spots to each component
		
		WireSensor aWireSensor = new WireSensor();
		sensors.put(4, aWireSensor); //Assign fixed spots to each component
		
		CameraSensor aCameraSensor = new CameraSensor();
		sensors.put(5, aCameraSensor);
		
		return sensors;
	}

	private static PropulsorUnit getAPropulsionUnit() {
		return  new PropulsorUnit(new Wheel(10), new Engine(1));
	}
	
	private static SortedMap<Integer, PropulsorUnit> getAPropulsorUnitSet()
	{
		SortedMap<Integer, PropulsorUnit> propulsorUnits = new TreeMap<Integer, PropulsorUnit>();
		
		PropulsorUnit rightWheel = getAPropulsionUnit();
		PropulsorUnit leftWheel = getAPropulsionUnit();
		
		propulsorUnits.put(1, rightWheel);
		propulsorUnits.put(2, leftWheel);
		
		return propulsorUnits;
	}
	
}
