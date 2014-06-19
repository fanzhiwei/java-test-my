package net.fanzhiwei.design_pattern.factory_method.car_example;

public class Client {
	public static void main(String[] args) {
		CreatorInterface car_factory = new ConcreteCreatorAudi();
		ProductInterface car_ref = car_factory.createCar();
		car_ref.start();
		car_ref.stop();
	}
}
