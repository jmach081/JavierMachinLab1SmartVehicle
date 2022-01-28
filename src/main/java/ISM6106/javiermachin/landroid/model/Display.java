package ISM6106.javiermachin.landroid.model;
/**
 * Class to model the display
 * @author xmachin
 *
 */
public class Display {
	

	private String dpi; //Should be a number too
	/**
	 * The height of the screen
	 */
	private double height;
	/**
	 * The width of the screen
	 */
	private double width;

	public Display() 
	{
		this.height = 2;
		this.width = 2;
		this.dpi = String.valueOf(this.height * this.width) + "dpi"; 
	}
	
	/**
	 * Display a message on the screen
	 */
	public void displayMessage(String message) {
		// TODO - implement Display.displayMessage
		throw new UnsupportedOperationException();
	}

	/**
	 * Display a warning message.
	 */
	public void displayErrorMessage(String message) {
		// TODO - implement Display.displayErrorMessage
		throw new UnsupportedOperationException();
	}

	public void displayWarningMessage(String message) {
		// TODO - implement Display.displayWarningMessage
		throw new UnsupportedOperationException();
	}
}
