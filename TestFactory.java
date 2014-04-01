package design.pattern;

interface Human{
	public void Talk();
	public void Walk();
}
class Boy implements Human{
	public void Talk() {
		System.out.println("Boy talk");
	}
	public void Walk() {
		System.out.println("Boy walk");
	}
}
class Girl implements Human{
	public void Talk() {
		System.out.println("Girl talk");
	}
	public void Walk() {
		System.out.println("Girl walk");
	}
}
public class TestFactory {
	public static Human createHuman(String m) {
		Human p = null;
		if (m == "boy") {
			p = new Boy();
		}else if(m == "girl"){
			p = new Girl();
		}
		return p;
	}
}
