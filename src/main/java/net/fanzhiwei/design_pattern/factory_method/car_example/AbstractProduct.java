package net.fanzhiwei.design_pattern.factory_method.car_example;

public abstract class AbstractProduct implements ProductInterface {
	private int speed;
	private String name;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void start();

	public abstract void stop();
}
