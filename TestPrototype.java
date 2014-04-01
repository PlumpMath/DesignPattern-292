package design.pattern;

interface Prototype{
	void setSize(int x);
	void printSize();
}
class A implements Prototype, Cloneable{
	private int size;
	public A(int x){
		this.size = x;
	}
	public void setSize(int x) {
		this.size = x;
	}
	public void printSize() {
		System.out.println("Size: " + size);
	}
	public A clone() throws CloneNotSupportedException{
		return (A)super.clone();
	}
}
public class TestPrototype {
	public static void main(String[] args) throws CloneNotSupportedException {
		A a = new A(1);
		for (int i = 2; i < 10; i++) {
			Prototype temp = a.clone();
			temp.setSize(i);
			temp.printSize();
 		}
	}
}
