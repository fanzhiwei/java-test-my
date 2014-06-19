package net.fanzhiwei.design_pattern.abstract_factory.car_example;

public class ProductTemplate implements AbstractProductI {

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

	public void start() {
		// TODO Auto-generated method stub

	}

	public void stop() {
		// TODO Auto-generated method stub

	}

}
