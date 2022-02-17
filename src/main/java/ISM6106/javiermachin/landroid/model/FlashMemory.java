package ISM6106.javiermachin.landroid.model;

import java.util.ArrayList;
import java.util.List;

/***
 * Class To Represent Flash Memory
 * 
 * @author xmachin
 *
 */
public class FlashMemory {

	String memoryType;
	int capacityMB;
	List<String> files;

	public FlashMemory() {
		memoryType = "NAND";
		capacityMB = 128;
		files = new ArrayList<String>();
	}

	public boolean deleteFile(String fileName) {
		// TODO: Implement copy file
		return true;
	}

	public boolean copyFile(String fileName) {
		// TODO: Implement copy file
		return true;
	}

	public String getFile(int index) {
		if (index < this.files.size() - 1)
			return this.files.get(this.files.size() - 1);
		return "";
	}

}
