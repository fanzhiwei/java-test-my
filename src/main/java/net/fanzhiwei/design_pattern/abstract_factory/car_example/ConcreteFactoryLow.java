package net.fanzhiwei.design_pattern.abstract_factory.car_example;

public class ConcreteFactoryLow implements AbstractFactoryI {
	public AbstractProductI createAudi() {

		ConcreteProductAudiLow carAudiLow = new ConcreteProductAudiLow();
		carAudiLow.setName("奥迪A6");
		carAudiLow.setSpeed(300);

		return carAudiLow;
	}

	public AbstractProductI create3W() {

		ConcreteProduct3WLow car3wLow = new ConcreteProduct3WLow();
		car3wLow.setName("大众A6");
		car3wLow.setSpeed(300);

		return car3wLow;
	}
}
