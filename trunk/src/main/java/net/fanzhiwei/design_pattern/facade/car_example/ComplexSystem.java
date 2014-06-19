package net.fanzhiwei.design_pattern.facade.car_example;

public class ComplexSystem {

	public void start() {
		System.out.println("车子已启动");
	}

	public void checkStop() {
		System.out.println("刹车检查");
	}

	public void checkBox() {
		System.out.println("检查油箱");
	}

	public void checkConsole() {
		System.out.println("检查仪表盘是否异常");
	}
}
