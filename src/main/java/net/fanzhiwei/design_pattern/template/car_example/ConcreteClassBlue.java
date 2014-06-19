package net.fanzhiwei.design_pattern.template.car_example;

public class ConcreteClassBlue extends AbstractClassCar {
	public void printSpeed() {
		super.printSpeed();
		System.out.println("将速度" + this.getSpeed() + "用蓝色的仪表盘显示车的速度");
	}
}
