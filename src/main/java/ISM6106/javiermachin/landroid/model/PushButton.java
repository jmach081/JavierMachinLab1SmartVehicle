package ISM6106.javiermachin.landroid.model;

/**
 * Button to start and stop manually
 */
public class PushButton {

	private boolean status;
	private String color;

	public PushButton() {
		this.status = false;
		this.color = "Red";
	}
	
	/**
	 * Press the pushbutton switch the boolean status
	 */
	public void pressButton() {
		this.status = !this.isStatus();
	}

	/**
	 * Gets the status of the button
	 * @return
	 */
	public boolean isStatus() {
		return status;
	}
	
}