package net.fanzhiwei.design_pattern.abstract_factory.car_example;

public class Client {
	public static void main(String[] args) {

		AbstractFactoryI carFactoryAdv = new ConcreteFactoryAdv();

		AbstractProductI carAdv = carFactoryAdv.create3W();
		carAdv.start();
		carAdv.stop();
	}
}
