package net.fanzhiwei.design_pattern.factory_method.car_example;

public class ConcreteProduct3W extends AbstractProduct {

	@Override
	public void start() {
		System.out.println(this.getName() + " 车以专利技术起动了　最高速度为："
				+ this.getSpeed());
	}

	@Override
	public void stop() {
		System.out.println(this.getName() + " 车以专利技术停车了");

	}

}
