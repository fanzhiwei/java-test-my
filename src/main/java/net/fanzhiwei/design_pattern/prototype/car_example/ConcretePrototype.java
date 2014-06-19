package net.fanzhiwei.design_pattern.prototype.car_example;

public class ConcretePrototype implements PrototypeInterface, Cloneable {
	private CarTyre carTyre;

	@Override
	public void start() {
		System.out.println("奥迪A6启动了");
	}

	@Override
	public void stop() {
		System.out.println("奥迪A6停止了");
	}

	public CarTyre getCarTyre() {
		return carTyre;
	}

	public void setCarTyre(CarTyre carTyre) {
		this.carTyre = carTyre;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		super.clone();// 没用的调用，因为下面是返回的new对象。
		ConcretePrototype audiImple = new ConcretePrototype();
		audiImple.setCarTyre(new CarTyre());

		return audiImple;
	}
}
