Example: BufferReader decorators InputStreamReader
BufferReader input = new BufferReader(new InputStreamReader(System.in));
//InputStreamReader(InputStream in)-bridge from byte streams to character streams.
//BufferReader(Reader in)-read text from a character stream and buffer characters in order to provide efficient reading methods.(eg:readLine())
package design.pattern;

abstract class Girl{
	String description = "no particular";
	public String getDescription() {
		return description;
	}
}
class AmericanGirl extends Girl{
	public AmericanGirl() {
		description = "+American";
	}
}
class EuropeanGirl extends Girl{
	public EuropeanGirl() {
		description = "+European";
	}
}
abstract class GirlDecorator extends Girl{
	public abstract String getDescription();
}
class Science extends GirlDecorator{
	private Girl girl;
	public Science(Girl g) {
		girl = g;
	}
	public String getDescription() {
		return girl.getDescription() + " Like Science";
	}
	public void caltulateStuff(){
		System.out.println("scientific calculation");
	}
}
class Art extends GirlDecorator{
	private Girl girl;
	public Art(Girl g) {
		girl = g;
	}
	public String getDescription() {
		return girl.getDescription() + " Like Art";
	}
	public void draw(){
		System.out.println("draw pictures");
	}
}

public class TestDecorator {
	public static void main(String[] args) {
		Girl g1 = new AmericanGirl();
		System.out.println(g1.getDescription());
		Science g2 = new Science(g1);
		System.out.println(g2.getDescription());
		Art g3 = new Art(g2);	// Girl g = new Science(new Art(new AmericanGirl));
		System.out.println(g3.getDescription());		
	}
}
