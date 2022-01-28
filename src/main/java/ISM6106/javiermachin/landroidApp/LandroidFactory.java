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
		SortedMap<Integer, SelfCheckCapable> sensors = new TreeMap<Integer, SelfCheckCapable>();
		
		//Build the sensor parts
		ControlPanel controlPanel = getControlPanel();
		sensors.put(1, controlPanel); //Assign fixed spots to each component

		PositionSensor aPositionSensor = new PositionSensor();
		
		
		
		switch (landroidType) {
		case OneFourthAcre:
			Landroid medLandroid = new Landroid("OneFourthAcre Landroid", LandroidType.OneFourthAcre, new Battery());
			medLandroid.setSensorArray(sensors);
			return medLandroid;
		case HalfAcre:
			Landroid bigLandroid = new Landroid("HalfAcre Landroid", LandroidType.HalfAcre, new Battery());
			bigLandroid.setSensorArray(sensors);
			return bigLandroid;
		case OneEightAcre:
		default:
			var littleLandroid = new Landroid("OneEightAcre Landroid", LandroidType.OneEightAcre, new Battery(BateryType.NiMH,500,500));
			littleLandroid.setSensorArray(sensors);
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
	
}
