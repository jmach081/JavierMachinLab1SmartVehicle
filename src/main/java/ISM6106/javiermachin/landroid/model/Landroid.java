package ISM6106.javiermachin.landroid.model;

/**
 * Class to represent a Landroid
 * @author xmachin
 *
 */
public class Landroid {
	
	private LandroidSize landroidType; // The type of the Landroid only 3 types on production
	private String nickName; // Nick name set by the owner
	
	public Landroid(LandroidSize landroidSize) {
		this.landroidType = landroidSize;
	}

	/**
	 * Gets the type of the Landroid
	 * @return
	 */
	public LandroidSize getLandroidType() {
		return landroidType;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
