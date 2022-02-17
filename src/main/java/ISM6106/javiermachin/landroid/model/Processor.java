package ISM6106.javiermachin.landroid.model;

import edu.fiu.jit.SelfCheckUtils;

/**
 * Represents the compute unit
 */
public class Processor {

	private String model;
	private FlashMemory flashMemory;
	private String currentFirmware;

	public Processor() {
		this.model = "MT3620";
		this.flashMemory = new FlashMemory();
		this.flashMemory.copyFile("Firmware 1.0.0.0");
		currentFirmware = this.flashMemory.getFile(0);
	}
	
	public String getModel() {
		return this.model;
	}

	public void calculateNextMove() {
		// TODO - implement Processor.claculateNextMove
		throw new UnsupportedOperationException();
	}

	public void identifyObstacle() {
		// TODO - implement Processor.identifyObstacle
		throw new UnsupportedOperationException();
	}

	public void checkOperationalStatus() {
		// TODO - implement Processor.checkOperationalStatus
		throw new UnsupportedOperationException();
	}
	
	public String getCurrentFirmware() {
		return this.currentFirmware;
	}

	/**
	 * Checks if the current firmware has a valid checksum
	 * @return
	 */
	public boolean md5ChecksumTest(String fileName) {
		return SelfCheckUtils.randomCheck(0.1); 
	}
}