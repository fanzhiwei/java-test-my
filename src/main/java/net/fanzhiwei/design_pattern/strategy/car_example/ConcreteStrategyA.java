package net.fanzhiwei.design_pattern.strategy.car_example;

public class ConcreteStrategyA implements StrategyInterface {

	@Override
	public void printTyreLine() {
		System.out.println("在路面上显示一个长轮胎痕迹");
	}
}
