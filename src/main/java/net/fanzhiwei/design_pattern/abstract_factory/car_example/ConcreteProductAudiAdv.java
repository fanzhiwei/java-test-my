package net.fanzhiwei.design_pattern.abstract_factory.car_example;

public class ConcreteProductAudiAdv extends ProductTemplate {

	public void start() {
		System.out.println("富华版：" + this.getName() + " 车以专利技术起动了　最高速度为："
				+ this.getSpeed());
	}

	public void stop() {
		System.out.println("富华版：" + this.getName() + " 车以专利技术停车了");
	}

}
