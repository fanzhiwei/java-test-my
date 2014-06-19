package net.fanzhiwei.design_pattern.template.car_example;

public class Client {
	public static void main(String[] args) {

		AbstractClassCar carRed = new ConcreteClassRed();
		carRed.setSpeed(300);
		carRed.printSpeed();

		AbstractClassCar carBlue = new ConcreteClassBlue();
		carBlue.setSpeed(400);
		carBlue.printSpeed();
	}
}
