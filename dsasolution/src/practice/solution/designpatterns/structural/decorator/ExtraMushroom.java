package practice.solution.designpatterns.structural.decorator;

public class ExtraMushroom extends ToppingDecorator {

	BasePizza basePizza;

	public ExtraMushroom(BasePizza basePizza) {
		this.basePizza = basePizza;
	}

	@Override
	int cost() {
		return this.basePizza.cost() + 50;
	}

}
