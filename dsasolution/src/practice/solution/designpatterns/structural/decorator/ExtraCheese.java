package practice.solution.designpatterns.structural.decorator;

public class ExtraCheese extends ToppingDecorator {

	BasePizza basePizza;

	public ExtraCheese(BasePizza basePizza) {
		this.basePizza = basePizza;
	}

	@Override
	int cost() {
		return this.basePizza.cost() + 50;
	}

}
