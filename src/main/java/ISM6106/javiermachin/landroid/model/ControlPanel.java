package ISM6106.javiermachin.landroid.model;

import edu.fiu.jit.SelfCheckCapable;

public class ControlPanel implements SelfCheckCapable {

	private KeyPad keyPad;
	private Display display;
	private RotarySelector rotarySelector;
	private PushButton pushButton;

	public ControlPanel(KeyPad keyPad, Display display, RotarySelector rotarySelector, PushButton pushButton) {
		this.keyPad = keyPad;
		this.display = display;
		this.rotarySelector = rotarySelector;
		this.pushButton = pushButton;
	}

	@Override
	public String getComponentName() {
		return "ControlPanel";
	}

	@Override
	public boolean selfCheck() {
		System.out.println("ControlPanel System check....");

		int errorCount = 0;

		if (this.getKeyPad() == null) {
			errorCount++;
			System.out.println("ControlPanel: missing keypad");
		}
		
		if (this.getDisplay() == null) {
			errorCount++;
			System.out.println("ControlPanel: missing display");
		}
		
		if (this.getRotarySelector() == null) {
			errorCount++;
			System.out.println("ControlPanel: missing rotarySelector");
		}
		
		if (this.getPushButton() == null) {
			errorCount++;
			System.out.println("ControlPanel: missing pushButton");
		}
		
		System.out.println("ControlPanel System check Found ( " + errorCount + " ) errors.");

		// If no errors system check true otherwise false
		return (errorCount == 0);
	}

	public KeyPad getKeyPad() {
		return keyPad;
	}

	public Display getDisplay() {
		return display;
	}

	public RotarySelector getRotarySelector() {
		return rotarySelector;
	}

	public PushButton getPushButton() {
		return pushButton;
	}
	
	public void pressKeys(String[] keys) {
		this.getKeyPad().pressKeys(keys);
	}

}
