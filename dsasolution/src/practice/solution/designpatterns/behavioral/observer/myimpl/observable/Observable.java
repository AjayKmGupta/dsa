package practice.solution.designpatterns.behavioral.observer.myimpl.observable;

import practice.solution.designpatterns.behavioral.observer.myimpl.observer.Observer;

public interface Observable {

	void register(Observer o);
	
	void unRegister(Observer o);

	void notifyObserver(String message);

}
