package practice.solution.designpatterns.behavioral.observer.myimpl.observable;

import java.util.ArrayList;
import java.util.List;

import practice.solution.designpatterns.behavioral.observer.myimpl.observer.Observer;

public class ProductObservable implements Observable {

	List<Observer> observers;

	public ProductObservable() {
		observers = new ArrayList<>();
	}

	@Override
	public void register(Observer o) {
		observers.add(o);
	}

	@Override
	public void unRegister(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObserver(String message) {
		observers.forEach(o -> o.update(message));
	}

}
