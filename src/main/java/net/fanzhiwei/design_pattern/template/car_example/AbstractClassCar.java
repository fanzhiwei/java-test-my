package net.fanzhiwei.design_pattern.template.car_example;

public class AbstractClassCar {
	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void printSpeed() {
		System.out.println("将速度" + this.getSpeed() + "取出来！");
	}
}
