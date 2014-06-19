package net.fanzhiwei.design_pattern.facade.car_example;

public class Client {
	public static void main(String[] args) {
		Facade carFacade = new Facade();
		carFacade.carGoGo(new ComplexSystem());
	}
}
