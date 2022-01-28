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
				+ aBigLandroid.getLandroidType() + " model");
		
		aBigLandroid.systemCheck();
		
//		System.out.println(aBigLandroid.getClass().toString());
		
	}
	
	
	/*Test methods to move to */

}
