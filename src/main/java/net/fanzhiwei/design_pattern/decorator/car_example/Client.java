package net.fanzhiwei.design_pattern.decorator.car_example;

public class Client {

	public static void main(String[] args) {

		ConcreteComponent audiComponent = new ConcreteComponent();
		audiComponent.setMakeAddress("北京市朝阳区");
		audiComponent.setSpeed(200);

		DecoratorImpl1 decoratorAudiRed = new DecoratorImpl1();
		decoratorAudiRed.setCarComponent(audiComponent);

		DecoratorImpl2 decoratorAudiPurple = new DecoratorImpl2();
		decoratorAudiPurple.setCarComponent(decoratorAudiRed);

		decoratorAudiPurple.printFace();
	}
}
