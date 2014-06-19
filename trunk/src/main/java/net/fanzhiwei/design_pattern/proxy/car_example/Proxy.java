package net.fanzhiwei.design_pattern.proxy.car_example;

public class Proxy implements SubjectInterface {
	private RealSubject realSubject;

	public Proxy(RealSubject people) {
		this.realSubject = people;
	}

	public RealSubject getPeople() {
		return realSubject;
	}

	public void setPeople(RealSubject people) {
		this.realSubject = people;
	}

	public void buyCar() {
		if (realSubject.getCash() > 3000) {
			realSubject.setCash(realSubject.getCash() - 3000);
			System.out.println(realSubject.getUsername() + "花3000块　买了新车　交易结束");
		} else {
			System.out.println(realSubject.getUsername() + "金钱不够，请继续比赛!");
		}
	}
}
