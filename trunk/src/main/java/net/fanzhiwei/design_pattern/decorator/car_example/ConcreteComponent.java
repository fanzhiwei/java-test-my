package net.fanzhiwei.design_pattern.decorator.car_example;

public class ConcreteComponent extends ComponentInterface {

	@Override
	public void printFace() {
		System.out.println("audi车默认的颜色为　黑色");
	}
}
