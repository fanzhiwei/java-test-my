package net.fanzhiwei.design_pattern.builder.car_example;

public class ConcreteBuilder2 implements BuilderInterface {

	public void createWeather() {
		System.out.println("阴天");
	}

	public void createHouse() {
		System.out.println("房了上玻璃发暗");
	}

	public void createTree() {
		System.out.println("树的颜色是深绿色");
	}

	public void createWay() {
		System.out.println("路面有些潮湿");
	}

}
