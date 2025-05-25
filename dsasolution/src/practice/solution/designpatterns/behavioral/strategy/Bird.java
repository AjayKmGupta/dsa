package practice.solution.designpatterns.behavioral.strategy;

public class Bird extends Animal {

	public Bird() {
		super();
		setSound("Tweet");
		flyingType = new ItFlys();
	}

}
