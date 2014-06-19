package net.fanzhiwei.design_pattern.builder.car_example;

public class Client {
	public static void main(String[] args) {

		ConcreteBuilder1 mapCloudy = new ConcreteBuilder1();
		DirectorAdv directorAdv = new DirectorAdv(mapCloudy);
		directorAdv.createMap();

		System.out.println();

		ConcreteBuilder2 mapSun = new ConcreteBuilder2();
		DirectorLow directorLow = new DirectorLow(mapSun);
		directorLow.createMap();

	}
}
