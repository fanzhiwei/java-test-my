package net.fanzhiwei.design_pattern.observer.car_example;

public class ConcreteObserver implements ObserverInterface {

	private SubjectInterface subject;

	public SubjectInterface getSubject() {
		return subject;
	}

	public void setSubject(SubjectInterface subject) {
		this.subject = subject;
	}

	public ConcreteObserver(SubjectInterface subject) {
		super();
		this.subject = subject;
	}

	public void showInfo() {
		System.out.println(subject.getState());
	}
}
