package practice.solution.designpatterns.behavioral.observer;

public interface Subject {

	public void register(Observer o);

	public void unRegister(Observer o);

	public void notifyObserver();
	
}
