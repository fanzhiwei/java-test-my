package net.fanzhiwei.design_pattern.proxy.car_example;

public class Client {
	public static void main(String[] args) {
		RealSubject people1 = new RealSubject(4000, "高富帅");
		RealSubject people2 = new RealSubject(1000, "穷矮挫");

		Proxy proxyBuyCar = new Proxy(people1);
		proxyBuyCar.buyCar();

		proxyBuyCar.setPeople(people2);
		proxyBuyCar.buyCar();
	}
}
