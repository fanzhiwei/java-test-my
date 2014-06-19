package net.fanzhiwei.design_pattern.builder.car_example;

public class DirectorLow {
	private BuilderInterface builder;

	public DirectorLow(BuilderInterface builder) {
		super();
		this.builder = builder;
	}

	public void createMap() {
		System.out.println("创建一个高画质的地图");
		// 创建的顺序很重要 从天空往路面创建
		builder.createWeather();
		builder.createHouse();
		// map_interface_ref.create_tree();将创建树的过程去掉
		builder.createWay();
	}
}
