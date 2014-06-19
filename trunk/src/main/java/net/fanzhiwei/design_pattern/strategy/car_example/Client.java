package net.fanzhiwei.design_pattern.strategy.car_example;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConcreteStrategyA tyreLong = new ConcreteStrategyA();
		// ConcreteStrategyB tyreShort = new ConcreteStrategyB();
		Context car = new Context();
		car.setDeathYear(8);
		car.setMakeAddress("北京朝阳区");
		car.setSpeed(200);
		car.setTyreStyle(tyreLong);
		car.start();
	}
}
