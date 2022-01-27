package ISM6106.javiermachin.landroid.model.unitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ISM6106.javiermachin.landroid.model.BateryType;
import ISM6106.javiermachin.landroid.model.Battery;

class batteryTest {

	Battery aDefaultBattery = new Battery();

	@Test
	void a_default_battery_should_be_fully_charged() {
		assertTrue(aDefaultBattery.getChargeStatus() == 100, "Battery by default not charged 100%");
	}

	@Test
	void a_default_battery_should_be_of_type_NiCad() {
		assertTrue(aDefaultBattery.getBateryType() == BateryType.NiCad, "Default battery type not correct.");
	}
	
	@Test
	void a_battery_one_time_electricity_use_should_use_a_single_unit() {
		Battery aBattery = new Battery(BateryType.NiMH, 1000, 1000);
		assertTrue(aBattery.getChargeStatus() == 100, "Charge status not 100% as expected");
		aBattery.getElectricity();
		System.out.println(aBattery.getChargeStatus());
		assertTrue(aBattery.getChargeStatus() < 100);
	}
	
	@Test
	void a_custom_battery_should_display_chargeStatus() {
		double capacity = 100;
		double chargeStatus = capacity / 2;
		Battery aBattery = new Battery(BateryType.NiMH, capacity, chargeStatus);
		
		System.out.println(aBattery.getChargeStatus());
		assertTrue(aBattery.getChargeStatus() == 50, "Charge status not " + chargeStatus + "% as expected");
	}
}
