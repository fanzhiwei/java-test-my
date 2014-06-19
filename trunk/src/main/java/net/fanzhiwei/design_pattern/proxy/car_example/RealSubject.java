package net.fanzhiwei.design_pattern.proxy.car_example;

public class RealSubject implements SubjectInterface {// realSubject
	private int cash;
	private String userName;

	public RealSubject(int cash, String userName) {
		this.cash = cash;
		this.userName = userName;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public String getUsername() {
		return userName;
	}

	public void buyCar() {
		System.out.println(userName + "买了一台新车");
	}
}
