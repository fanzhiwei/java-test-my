package net.fanzhiwei.design_pattern.decorator.car_example;

public class DecoratorInterface extends ComponentInterface {
	// 装饰者父类
	protected ComponentInterface carComponent;

	public void setCarComponent(ComponentInterface carComponent) {
		this.carComponent = carComponent;
	}

	@Override
	public void printFace() {
		carComponent.printFace();
	}
}
