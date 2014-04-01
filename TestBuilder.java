package design.pattern;

class Starbucks{
	private String size;
	private String drink;
	public void setSize(String size) {
		this.size = size;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
}
abstract class StarbucksBuilder{
	protected Starbucks starbucks;
	public Starbucks getStarbucks() {
		return starbucks;
	}
	public void createStarbucks(){
		starbucks = new Starbucks();
		System.out.println("create a drink");
	}
	public abstract void buildSize();
	public abstract void buildDrink();
}
class CoffeeBuilder extends StarbucksBuilder{
	public void buildSize() {
		starbucks.setSize("medium");
		System.out.println("build medium size");
	}
	public void buildDrink() {
		starbucks.setDrink("coffee");
		System.out.println("build coffee");
	}
}
class Waiter{
	private StarbucksBuilder starbucksBuilder;
	public void setStarbucksBuilder(StarbucksBuilder starbucksBuilder) {
		this.starbucksBuilder = starbucksBuilder;
	}
	public Starbucks getStarbucksDrink() {
		return starbucksBuilder.getStarbucks();
	}
	public void constructStarbucks(){
		starbucksBuilder.createStarbucks();
		starbucksBuilder.buildDrink();
		starbucksBuilder.buildSize();
	}
}
public class TestBuilder {
	public static void main(String[] args) {
		Waiter waiter = new Waiter();
		StarbucksBuilder coffBuilder = new CoffeeBuilder();
		waiter.setStarbucksBuilder(coffBuilder);
		waiter.constructStarbucks();
		
		Starbucks drinkStarbucks = waiter.getStarbucksDrink();
	}
}
