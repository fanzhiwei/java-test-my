package net.fanzhiwei.design_pattern.template.car_example;

public class ConcreteClassRed extends AbstractClassCar {
	@Override
	public void printSpeed() {
		super.printSpeed();
		System.out.println("将速度" + this.getSpeed() + "用红色的仪表盘显示车的速度");
	}
}
