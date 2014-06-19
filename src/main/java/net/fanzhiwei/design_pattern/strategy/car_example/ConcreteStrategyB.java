package net.fanzhiwei.design_pattern.strategy.car_example;

public class ConcreteStrategyB implements StrategyInterface {

	@Override
	public void printTyreLine() {
		System.out.println("在路面上显示一个短轮胎痕迹");
	}
}
