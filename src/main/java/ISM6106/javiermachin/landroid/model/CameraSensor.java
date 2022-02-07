package ISM6106.javiermachin.landroid.model;

import edu.fiu.jit.SelfCheckUtils;

public class CameraSensor extends Sensor {

	private int resolution;

	public CameraSensor() {
		this.resolution = 1200;
	}

	public void captureImage() {
		System.out.println("CameraSensor taking picture...1 2 3..");
		System.out.println("Click");
		System.out.println("CameraSensor taking picture...End");
	}

	@Override
	public void scan() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void sendSignal() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public String getComponentName() {
		return "CameraSensor";
	}

	@Override
	public boolean selfCheck() {
		boolean checkResult = SelfCheckUtils.randomCheck(0.1);

		if (checkResult)
			System.out.println("CameraSensor check... OK");
		else
			System.out.println("CameraSensor check... Bad");

		return checkResult;
	}

}