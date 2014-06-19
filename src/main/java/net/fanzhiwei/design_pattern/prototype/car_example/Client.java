package net.fanzhiwei.design_pattern.prototype.car_example;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ConcretePrototype carMyAudi = new ConcretePrototype();
			carMyAudi.setCarTyre(new CarTyre());
			System.out.println("我的奥迪车的参数是：" + carMyAudi);
			System.out.println("我的奥迪车的轮胎参数是：" + carMyAudi.getCarTyre());

			ConcretePrototype carOtherAudi = (ConcretePrototype) carMyAudi
					.clone();
			System.out.println("其它人的奥迪车的参数是：" + carOtherAudi);
			System.out.println("其它人的奥迪车的轮胎参数是：" + carOtherAudi.getCarTyre());

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
