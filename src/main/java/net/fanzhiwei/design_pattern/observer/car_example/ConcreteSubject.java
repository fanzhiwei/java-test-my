package net.fanzhiwei.design_pattern.observer.car_example;

import java.util.*;

public class ConcreteSubject implements SubjectInterface {
	List<ObserverInterface> listObserver = new ArrayList<ObserverInterface>();

	private String state;

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void addObserver(ObserverInterface observer) {
		listObserver.add(observer);
	}

	public void subObserver(ObserverInterface observer) {
		listObserver.remove(observer);

	}

	public void notity() {
		state = "到达终点";
		for (int i = 0; i < listObserver.size(); i++) {
			listObserver.get(i).showInfo();
		}

	}
}
