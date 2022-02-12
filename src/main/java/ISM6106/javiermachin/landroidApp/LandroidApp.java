/**
 * 
 */
package ISM6106.javiermachin.landroidApp;

import ISM6106.javiermachin.landroid.model.*;

/**
 * @author xmachin
 *
 */
public class LandroidApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Landroid aBigLandroid = LandroidFactory.getALandroid(LandroidType.HalfAcre);
		aBigLandroid.setNickName("R2D2");
		System.out.println("Your landroid nicknamed: " + aBigLandroid.getNickName() + " is a "
				+ aBigLandroid.getLandroidType() + " model"  + "\n");
		
//		aBigLandroid.turnOn();

		System.out.println(aBigLandroid);
		System.out.println();
		aBigLandroid.selfCheck();
		
		
//		System.out.println(aBigLandroid.getNickName() + " ready to rumble ");
//		aBigLandroid.moveForward();
//		aBigLandroid.turnLeft();
//		aBigLandroid.moveForward();
//		aBigLandroid.turnRight();
//		aBigLandroid.stop();
	}

}
