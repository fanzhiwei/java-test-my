//将子操作用一个外观接口封装起来，然后调用这个接口就是调用那些非常复杂的微操作了。
package net.fanzhiwei.design_pattern.facade.car_example;

public class Facade {
	public void carGoGo(ComplexSystem car) {
		car.checkBox();
		car.checkConsole();
		car.checkStop();
		car.start();
	}
}
