package ISM6106.javiermachin.landroid.model;

/**
 * Represents the wheel to use in the landroid
 * @author xmachin
 *
 */
public class Wheel {

	private double radiusInch;
	private double thread = 3.5;

	public Wheel(double radius) {
		this.radiusInch = radius;
	}

	public double getSize() {
		return 2 * this.radiusInch * 3.14; 
	}

}