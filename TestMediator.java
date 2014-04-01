package design.pattern;

//Some Comment
interface IMediator{
	public void fight();
	public void talk();
	public void registerA(ColleagueA a);
	public void registerB(ColleagueB b);
}
class ConcreteMediator implements IMediator{
	ColleagueA talk;
	ColleagueB fight;
	public void fight() {
		System.out.println("Mediator is fighting");
	}
	public void talk() {
		System.out.println("Mediator is talking");
	}
	public void registerA(ColleagueA a) {
		talk = a;
	}
	public void registerB(ColleagueB b) {
		fight = b;
	}
}
abstract class Colleague{
	IMediator mediator;
	public abstract void doSomething();
}
class ColleagueA extends Colleague{
	public ColleagueA(IMediator mediator){
		this.mediator = mediator;
	}
	public void doSomething() {
		this.mediator.talk();
		this.mediator.registerA(this);
	}
}
class ColleagueB extends Colleague{
	public ColleagueB(IMediator mediator){
		this.mediator = mediator;
		this.mediator.registerB(this);
	}
	public void doSomething() {
		this.mediator.fight();
	}
}
public class TestMediator {
	public static void main(String[] args) {
		IMediator mediator = new ConcreteMediator();
		ColleagueA talkA = new ColleagueA(mediator);
		ColleagueB fightB = new ColleagueB(mediator);
		
		talkA.doSomething();
		fightB.doSomething();
	}
}
