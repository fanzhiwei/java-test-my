package net.fanzhiwei.design_pattern.abstract_factory.car_example;

public class ConcreteFactoryAdv implements AbstractFactoryI {
	public AbstractProductI createAudi() {

		ConcreteProductAudiAdv carAudiAdv = new ConcreteProductAudiAdv();
		carAudiAdv.setName("奥迪A6");
		carAudiAdv.setSpeed(300);

		return carAudiAdv;
	}

	public AbstractProductI create3W() {

		ConcreteProduct3WAdv car3wAdv = new ConcreteProduct3WAdv();
		car3wAdv.setName("大众A6");
		car3wAdv.setSpeed(300);

		return car3wAdv;
	}

}
