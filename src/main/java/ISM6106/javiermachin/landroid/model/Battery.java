package ISM6106.javiermachin.landroid.model;

import edu.fiu.jit.SelfCheckCapable;

public class Battery implements SelfCheckCapable {

	private BateryType bateryType;
	private double capacity;
	private double chargeStatus;

	public Battery() {
		this.bateryType = BateryType.NiCad;
		this.capacity = 1000;
		this.chargeStatus = 1000;
	}

	public Battery(BateryType bateryType, double capacity, double chargeStatus) {
		this.bateryType = bateryType;
		this.capacity = capacity;
		this.chargeStatus = chargeStatus;
	}

	/**
	 * Charge the battery fully
	 */
	public void chargeBattery() {
		this.chargeBattery(this.capacity);
	}

	/**
	 * Charges the battery some amount of units
	 * 
	 * @param chargeUnits
	 */
	public void chargeBattery(double chargeUnits) {
		if (this.chargeStatus + chargeUnits >= this.capacity)
			this.chargeStatus = this.capacity;
		else
			this.chargeStatus = this.chargeStatus + chargeUnits;
	}

	/**
	 * Drains one unit of charge from the battery
	 */
	public void getElectricity() {
		this.chargeStatus = this.chargeStatus - 1;
	}

	/**
	 * Returns the current status of battery
	 * @return
	 */
	public double getChargeStatus() {
		return this.chargeStatus * 100 / this.capacity;
	}

	@Override
	public String getComponentName() {
		return "Battery Type: " + this.getBateryType() + " Capacity: " + this.capacity;
	}

	/**
	 * If battery is charged above 25% returns true otherwise false
	 */
	@Override
	public boolean selfCheck() {
		if (this.chargeStatus * 100 / this.capacity > 25)
			return true;
		return false;
	}

	public BateryType getBateryType() {
		return bateryType;
	}
}