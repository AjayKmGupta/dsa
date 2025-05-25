package practice.solution.designpatterns.behavioral.observer.myimpl.observable;

import practice.solution.designpatterns.behavioral.observer.myimpl.observer.Observer;
import practice.solution.designpatterns.behavioral.observer.myimpl.observer.ObserverImpl;

public class ProductInventoryManager {

	public static void main(String[] args) {

		Observer indiaObserver = new ObserverImpl("India");
		Observer chinaObserver = new ObserverImpl("China");

		Observable observable = new ProductObservable();
		observable.register(indiaObserver);
		observable.register(chinaObserver);

		Product prod = new Product(observable);

		prod.setId("1");
		prod.setName("Mobile Phone");
		prod.setAvailable(true);

	}

}
