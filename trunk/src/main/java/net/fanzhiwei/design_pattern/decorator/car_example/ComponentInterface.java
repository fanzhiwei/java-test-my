package net.fanzhiwei.design_pattern.decorator.car_example;

public abstract class ComponentInterface {
	// 汽车抽象父类
	private String makeAddress;
	private int speed;

	public String getMakeAddress() {
		return makeAddress;
	}

	public void setMakeAddress(String makeAddress) {
		this.makeAddress = makeAddress;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public abstract void printFace();
}
