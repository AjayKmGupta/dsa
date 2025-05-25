package practice.solution.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber implements Subject {

	private List<Observer> observers;

	private double ibmPrice;
	private double aaplPrice;
	private double googlPrice;

	public StockGrabber() {
		observers = new ArrayList<>();
	}

	@Override
	public void register(Observer o) {
		observers.add(o);
	}

	@Override
	public void unRegister(Observer o) {
		int observerIndex = observers.indexOf(o);
		System.out.println("Observer: " + (observerIndex + 1) + " deleted");
		observers.remove(observerIndex);
	}

	@Override
	public void notifyObserver() {

		observers.forEach(o -> o.update(ibmPrice, aaplPrice, googlPrice));
	}

	public void setIBMPrice(double ibmPrice) {
		this.ibmPrice = ibmPrice;
		notifyObserver();
	}

	public void setAAPLPrice(double aaplPrice) {
		this.aaplPrice = aaplPrice;
		notifyObserver();
	}

	public void setGOOGLPrice(double googlPrice) {
		this.googlPrice = googlPrice;
		notifyObserver();
	}

}
