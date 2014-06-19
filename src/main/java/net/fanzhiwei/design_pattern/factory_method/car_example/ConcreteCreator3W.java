package net.fanzhiwei.design_pattern.factory_method.car_example;

public class ConcreteCreator3W implements CreatorInterface {

	public AbstractProduct createCar() {

		AbstractProduct car3W = new ConcreteProduct3W();
		car3W.setName("大众A6");
		car3W.setSpeed(400);

		return car3W;
	}
}
