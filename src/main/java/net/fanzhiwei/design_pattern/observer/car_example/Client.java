package net.fanzhiwei.design_pattern.observer.car_example;

public class Client {
	public static void main(String[] args) {

		SubjectInterface subject = new ConcreteSubject();

		ConcreteObserver carerObserverRef1 = new ConcreteObserver(subject);
		ConcreteObserver carerObserverRef2 = new ConcreteObserver(subject);
		ConcreteObserver carerObserverRef3 = new ConcreteObserver(subject);
		ConcreteObserver carerObserverRef4 = new ConcreteObserver(subject);

		subject.addObserver(carerObserverRef1);
		subject.addObserver(carerObserverRef2);
		subject.addObserver(carerObserverRef3);
		subject.addObserver(carerObserverRef4);

		subject.subObserver(carerObserverRef3);

		subject.setState("到达终点");

		subject.notity();
	}
}
