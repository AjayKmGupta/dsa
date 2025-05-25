package practice.solution.designpatterns.behavioral.observer.myimpl.observable;

public class Product {

	private String id;
	private String name;
	private boolean isAvailable;

	private Observable observable;

	public Product(Observable observable) {
		this.observable = observable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
		this.observable.notifyObserver("Product " + name + " available: " + isAvailable);
	}

}
