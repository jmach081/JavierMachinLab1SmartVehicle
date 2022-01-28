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
		
		Landroid bigLandroid = new Landroid("BigBot",LandroidType.HalfAcre);
		bigLandroid.setNickName("GreenEater");
		System.out.println("Your landroid nicknamed: " + bigLandroid.getNickName() + " is a "
				+ bigLandroid.getLandroidType() + " model");
	}
	
	
	/*Test methods to move to */

}
