package practice.solution.designpatterns.behavioral.observer.myimpl.observer;

public class ObserverImpl implements Observer {

	private String name;

	public ObserverImpl(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		System.out.println("In: " + name + " " + message);
	}

}
