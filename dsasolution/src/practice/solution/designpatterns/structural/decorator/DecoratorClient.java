package practice.solution.designpatterns.structural.decorator;

public class DecoratorClient {

	public static void main(String[] args) {

		BasePizza farmHouseWithCheeseAndMushroom = new ExtraMushroom(new ExtraCheese(new FarmHouse()));

		System.out.println("Final cost of order: " + farmHouseWithCheeseAndMushroom.cost());
	}

}
