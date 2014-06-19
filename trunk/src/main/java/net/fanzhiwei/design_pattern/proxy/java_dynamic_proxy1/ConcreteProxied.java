package net.fanzhiwei.design_pattern.proxy.java_dynamic_proxy1;

public class ConcreteProxied implements Proxied {
	@Override
	public void doSomething() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.err.println("Error : InterruptedException");
		}
		System.out.println(this.getClass().getSimpleName()
				+ " >> doSomething .");
	}

	@Override
	public void doSomethingElse(String str) {
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			System.err.println("Error : InterruptedException");
		}
		System.out.println(this.getClass().getSimpleName()
				+ " >> doSomethingElse , argument = " + str + ".");
	}
}
