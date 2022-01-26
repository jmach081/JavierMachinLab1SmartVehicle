package ISM6106.javiermachin.landroid.model;

public class Battery {

    private BateryType bateryType;
    private double capacity;
    private double chargeStatus;

    public Battery(BateryType bateryType, double capacity, double chargeStatus){
        this.bateryType = bateryType;
    }

    public void setChargeStatus(double chargeStatus) {
        this.chargeStatus = chargeStatus;
    }

	public void chargeBattery() {
		// TODO - implement Battery.chargeBattery
		throw new UnsupportedOperationException();
	}
}