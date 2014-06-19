package net.fanzhiwei.design_pattern.factory_method.car_example;

public class ConcreteCreatorAudi implements CreatorInterface {

	public AbstractProduct createCar() {

		AbstractProduct carAudi = new ConcreteProductAudi();
		carAudi.setName("奥迪A6");
		carAudi.setSpeed(300);

		return carAudi;
	}
}
