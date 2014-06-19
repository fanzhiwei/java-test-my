package net.fanzhiwei.design_pattern.strategy.car_example;

public class Context {
	private String makeAddress;// 制造地
	private int deathYear;// 报废年限
	private int speed;// 速度
	private StrategyInterface tyreStyle;// 轮胎的样式

	public String getMakeAddress() {
		return makeAddress;
	}

	public void setMakeAddress(String makeAddress) {
		this.makeAddress = makeAddress;
	}

	public int getDeathYear() {
		return deathYear;
	}

	public void setDeathYear(int deathYear) {
		this.deathYear = deathYear;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public StrategyInterface getTyreStyle() {
		return tyreStyle;
	}

	public void setTyreStyle(StrategyInterface tyreStyle) {
		this.tyreStyle = tyreStyle;
	}

	public void start() {
		System.out.println("车的基本信息为：");
		System.out.println("制造地make_address：" + this.getMakeAddress());
		System.out.println("报废年限death_year：" + this.getDeathYear());
		System.out.println("速度speed：" + this.getSpeed());
		System.out.println("Car 起动了！");
		System.out.println("Car高速行驶，遇到一个大转弯，路面显示：");
		this.getTyreStyle().printTyreLine();
	}
}
