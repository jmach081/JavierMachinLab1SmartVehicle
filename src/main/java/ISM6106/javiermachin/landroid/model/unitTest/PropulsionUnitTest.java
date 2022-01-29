package ISM6106.javiermachin.landroid.model.unitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ISM6106.javiermachin.landroid.model.Engine;
import ISM6106.javiermachin.landroid.model.PropulsorUnit;
import ISM6106.javiermachin.landroid.model.SpinningStatus;
import ISM6106.javiermachin.landroid.model.Wheel;

public class PropulsionUnitTest {

	@Test
	void a_default_propulsionUnit_should_be_created() {
		PropulsorUnit aPropulsionPropulsorUnit = new PropulsorUnit(new Wheel(10), new Engine(1));
		assertTrue(aPropulsionPropulsorUnit != null, "aPropulsionPropulsorUnit was not created");
	}
	
	@Test
	void a_propulsion_unit_should_be_on_stop_by_default() {
		PropulsorUnit aPropulsionPropulsorUnit = new PropulsorUnit(new Wheel(10), new Engine(1));
		assertTrue(aPropulsionPropulsorUnit.getSpinningStatus() == SpinningStatus.Stop, "aPropulsionPropulsorUnit was not stop by default");
	}
}
