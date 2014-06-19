package net.fanzhiwei.design_pattern.observer.car_example;

public interface SubjectInterface {
	public void setState(String state);

	public String getState();

	public void addObserver(ObserverInterface carerObserver);

	public void subObserver(ObserverInterface carerObserver);

	public void notity();
}
