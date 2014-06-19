package net.fanzhiwei.design_pattern.abstract_factory.car_example;

public class ConcreteProductAudiLow extends ProductTemplate {

	public void start() {
		System.out.println("普通版：" + this.getName() + " 车以专利技术起动了　最高速度为："
				+ this.getSpeed());
	}

	public void stop() {
		System.out.println("普通版：" + this.getName() + " 车以专利技术停车了");
	}

}
